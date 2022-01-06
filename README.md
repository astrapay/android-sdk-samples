# AstraPay SDK Example Project

This repository is an example about how to implement AstraPay Sdk in your project.

## Steps to implement SDK
1. Make sure your minimum SDK is 21

2. Put implementation 'com.astrapay:android-sdk:1.0.0' on build.gradle file.

```groovy
   dependencies {      
        //...
        implementation 'com.astrapay:android-sdk:1.0.0'
    }
```

You can check the new version on https://search.maven.org/artifact/com.astrapay/android-sdk

3. On your Application file, make sure to extend AstraPaySdkApplication() and setup the sdk on onCreate().
   
   Make sure add @SuppressLint("MissingSuperCall").
   This setup function require your sdk token and build environment.

```kotlin
class ClientApplication : AstraPaySdkApplication() {
    @SuppressLint("MissingSuperCall")
    override fun onCreate() {
        super.onCreate()
        AstraPayQris.setup("SDK_TOKEN", AstraPayQris.Build.SIT)
    }
}
```

4. Add tools:replace="android:name" on your manifest

```xml
   <application
        android:name=".YourApplication"
        tools:replace="android:name">
        ...
</application>
```

5. On your desired activity implement AstraPayQrisListener, then implement the methods.
   There is 4 callback that you can use:

    1. onComplete(type: EventType)
       
       This is a listener that you can use to listen when transaction is success.
       
       There is also 2 EventType that you can use:
       
       a. EventType.Home --> listener button KEMBALI KE BERANDA / back button from Success Page
       
       b. EventType.Detail --> listener back button from Detail Page

    2. onFailed()
       
       This is a listener that you can use to listen when transaction is failed, when button
       KEMBALI KE BERANDA is selected.

    3. onForbidden()
       
       This is a listener that you can use to listen when user token is expired and rejected by
       AstraPay system.

    4. onCancel()
       
       This is a listener that you can use to listen when user select back button from Scan QR page.

```kotlin
class MainActivity : AppCompatActivity(), AstraPayQrisListener {
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_main)
   }

   //On Transaction Complete
   override fun onComplete(type: EventType) {
   }

   //On Transaction Failed
   override fun onFailed() {
   }

   //On User token forbidden
   override fun onForbidden() {
   }

   //On User Cancel Transaction
   override fun onCancel() {
   }
}
```
6. On your desired action put AstraPayQris.execute() function

```kotlin
 val astraPayAuth = AstraPayQrisAuth(
   context = context,
   authorizationToken = "auth_token",
   listener = context
)

AstraPayQris.execute(
   astraPayQrisAuth = astraPayAuth
)
```
authorizationToken is the token that you get after the User (that have been linked to AstraPay
system) do login on your application.
