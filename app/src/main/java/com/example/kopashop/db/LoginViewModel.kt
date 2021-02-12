package com.example.kopashop.db

import android.content.SharedPreferences
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.crashlytics.FirebaseCrashlytics
import io.reactivex.*
import kotlinx.coroutines.runBlocking
import timber.log.Timber
import java.util.concurrent.TimeUnit

class LoginViewModel{
/*

constructor(
        private val loginRepository: LoginRepository,
        private val tokenRepository: TokenRepository,
        private val preferences: SharedPreferences
) :
        BaseViewModel() {

    val phone = ObservableField<String>("+38")
    val liveEventLogin = MutableLiveData<Unit>()
    val progressVisibility = MutableLiveData<ProgressVisibility>()
    val adminCreateEvent = MutableLiveData<Unit>()

    private val _seconds = MutableLiveData<Int>()
    val second: LiveData<Int> = _seconds

    val codeText = MutableLiveData<String>()

    private var seconds = 60
    var verificationId: String? = null

    private val _codeSent = SingleLiveEvent<Unit>()
    val codeSent: LiveData<Unit> = _codeSent

    private val _resendEnable = MutableLiveData<Boolean>()
    val resendEnable: LiveData<Boolean> = _resendEnable

    private var resentToken: PhoneAuthProvider.ForceResendingToken? = null

    private val _incorrectCode = MutableLiveData<Unit>()
    val incorrectCode: LiveData<Unit> = _incorrectCode

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _formState = MutableLiveData<LoginFormState>()
    val formState: LiveData<LoginFormState> = _formState

    private var admin = Admin()

    init {
        phone.onChange {
            if (isPhoneValid(phone.get())) {
                _formState.value = LoginFormState(dataValid = true)
            } else {
                _formState.value = LoginFormState(phoneNumberError = R.string.phone_number_error)
            }
        }
    }

    fun startTimer() {
        disposables + Observable.interval(1, TimeUnit.SECONDS)
                .take(seconds.toLong() + 1)
                .doOnComplete {
                    _resendEnable.postValue(true)
                }
                .subscribe {
                    _seconds.postValue(seconds - it.toInt())
                }

//        disposables + timer()
//            .doOnSubscribe {
//                _resendEnable.postValue(false)
//            }
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeBy(
//                onNext = {
//                    _seconds.postValue(it)
//                },
//                onComplete = {
//                    _resendEnable.postValue(true)
//
//                },
//                onError = {
//                    Timber.d(it)
//                }
//            )

    }

    fun verifyCode(code: String) {
        if (verificationId != null) {
            val credential = PhoneAuthProvider.getCredential(verificationId!!, code)
            codeText.postValue(code)
            signInWithCredential(credential)
        }
    }

    fun signInWithCredential(credential: PhoneAuthCredential) {
        progressVisibility.postValue(ProgressVisibility.SHOW)
        val auth = FirebaseAuth.getInstance().signInWithCredential(credential)
        auth.addOnSuccessListener {
            Timber.d("success")
            getOrganization()
        }
        auth.addOnCanceledListener {
            Timber.d("canceled")
        }
        auth.addOnCompleteListener {
            Timber.d("complete")
        }
        auth.addOnFailureListener {
            Timber.d("failed")
            if (it is FirebaseAuthInvalidCredentialsException) {
                Timber.d(it)
                Timber.d(it.localizedMessage)
                _incorrectCode.postValue(Unit)
                progressVisibility.postValue(ProgressVisibility.HIDE)
            }
        }
    }

    private fun getOrganization() {
//        disposables + loginRepository.getFCMToken()
//            .observeOn(Schedulers.io())
//            .flatMap {
//                return@flatMap loginRepository.getOrganizationByAdmin(it)
//            }
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .doAfterTerminate {
//                progressVisibility.postValue(ProgressVisibility.HIDE)
//            }
//            .subscribeBy(
//                onSuccess = {
//                    if (it.isSuccess()) {
//                        Config.getInstance().setConfig(it.data!!)
//                        liveEventLogin.postValue(Unit)
//                    } else {
//                        it.errors.handleServerErrors()
//                    }
//                },
//                onError = {
//                    it.handleResponseErrors()
//                }
//            )
        disposables + loginRepository.getFCMToken()
                .observeOn(Schedulers.io())
                .flatMap {
                    loginRepository.authAdmin(
                            body = PhoneModel(
                                    phone = phone.get() ?: "",
                                    uid = FirebaseAuth.getInstance().currentUser?.uid ?: "",
                                    fcmToken = FcmToken(
                                            device = "android",
                                            language = getLocaleDevice(),
                                            fcmToken = it
                                    )
                            )
                    )
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterTerminate {
                    progressVisibility.postValue(ProgressVisibility.HIDE)
                }
                .subscribeBy(
                        onSuccess = {
                            if (it.isSuccess()) {

                                AuthConfigWrapper.deleteConfig()
                                AuthConfigWrapper.setConfig(it.data!!)

                                val editor = preferences.edit()
                                editor.putString("adminPhoneNumber", phone.get())
                                editor.apply()

                                runBlocking {
                                    tokenRepository.updateCurrentTokens(AuthConfigWrapper.getInstance().tokens)
                                }

                                FirebaseCrashlytics.getInstance().setCustomKey(
                                        Crashlytics.COMPANY_ID,
                                        AuthConfigWrapper.getInstance().config.id
                                )
                                FirebaseCrashlytics.getInstance().setCustomKey(
                                        Crashlytics.UID,
                                        FirebaseAuth.getInstance().currentUser?.uid ?: ""
                                )

                                liveEventLogin.postValue(Unit)
                            } else {
                                it.error.handleServerErrors()
                            }
                        },
                        onError = {
                            it.handleResponseErrors()
                        }
                )
    }

    fun getPhone() = phone.get()

    fun getResentToken() = resentToken

    val callback = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        override fun onVerificationCompleted(credential: PhoneAuthCredential) {
            val code = credential.smsCode
            if (code != null) {
                verifyCode(code)
            } else {
                signInWithCredential(credential)
            }
        }

        override fun onVerificationFailed(e: FirebaseException) {
            progressVisibility.postValue(ProgressVisibility.HIDE)
            _error.postValue(e.message)
        }

        override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
            super.onCodeSent(p0, p1)
            verificationId = p0
            resentToken = p1
            _codeSent.postValue(Unit)
            startTimer()
        }

        override fun onCodeAutoRetrievalTimeOut(p0: String) {
            super.onCodeAutoRetrievalTimeOut(p0)
            Timber.d("time out")
        }
    }

    fun clearIncorrectCode() {
        _incorrectCode.value = null
    }

    fun clearSmsVerification() {
        disposables.clear()
        _seconds.value = null
        _resendEnable.value = null
        _incorrectCode.value = null
        seconds = 60
        verificationId = null
        resentToken = null
    }


 */
}
