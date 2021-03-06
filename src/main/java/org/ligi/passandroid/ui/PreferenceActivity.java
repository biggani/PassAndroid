package org.ligi.passandroid.ui;


import android.preference.Preference;

public class PreferenceActivity extends android.preference.PreferenceActivity implements Preference.OnPreferenceChangeListener {
    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
/*
    private static final int REQUEST_ACCOUNT_PICKER = 1;
    private static final int REQUEST_AUTHORIZATION = 2;
    private static Drive service;
    private CheckBoxPreference sync2driveCheckBoxPref;
    private GoogleAccountCredential credential;

    private PreferenceScreen createPreferenceHierarchy() {

        PreferenceScreen root = getPreferenceManager().createPreferenceScreen(this);

        root.setPersistent(true);
        // UI section
        //PreferenceCategory uiPrefCat = new PreferenceCategory(this);
        //uiPrefCat.setTitle(R.string.screen);
        //root.addPreference(uiPrefCat);


        sync2driveCheckBoxPref = new CheckBoxPreference(this);
        sync2driveCheckBoxPref.setKey("DRIVE_BACKUP");
        sync2driveCheckBoxPref.setTitle("Sync2Drive");
        sync2driveCheckBoxPref.setSummary("sync passes with Google-Drive");
        sync2driveCheckBoxPref.setDefaultValue(false);
        sync2driveCheckBoxPref.setOnPreferenceChangeListener(this);
        root.addPreference(sync2driveCheckBoxPref);

        return root;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        credential = GoogleAccountCredential.usingOAuth2(this, DriveScopes.DRIVE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setPreferenceScreen(createPreferenceHierarchy());
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {


        if (preference.equals(sync2driveCheckBoxPref) && (Boolean) newValue) {

            GoogleAccountCredential credential = GoogleAccountCredential.usingOAuth2(this, DriveScopes.DRIVE_FILE);
            startActivityForResult(credential.newChooseAccountIntent(), REQUEST_ACCOUNT_PICKER);
        }
        //
        // if ((preference==sgf_path_pref)||(preference==sgf_fname_pref)
		// ||(preference==boardSkinPref)|| (preference==stoneSkinPref)||
		// (preference==aiLevelPref)) preference.setSummary((String)newValue);

        return true; // return that we are OK with preferences
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        switch (requestCode) {
            case REQUEST_ACCOUNT_PICKER:
                if (resultCode == RESULT_OK && data != null && data.getExtras() != null) {
                    String accountName = data.getStringExtra(AccountManager.KEY_ACCOUNT_NAME);
                    if (accountName != null) {

                        credential.setSelectedAccountName(accountName);
                        service = getDriveService(credential);
                        saveFileToDrive();
                    }
                }
                break;
            case REQUEST_AUTHORIZATION:
                if (resultCode == Activity.RESULT_OK) {
                    saveFileToDrive();
                } else {
                    startActivityForResult(credential.newChooseAccountIntent(), REQUEST_ACCOUNT_PICKER);
                }
                break;


        }
    }

    private Drive getDriveService(GoogleAccountCredential credential) {
        return new Drive.Builder(AndroidHttp.newCompatibleTransport(), new GsonFactory(), credential)
                .build();
    }

    private void saveFileToDrive() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // File's binary content
                    java.io.File fileContent = new java.io.File("/sdcard/share.pkpass");
                    FileContent mediaContent = new FileContent("application/vnd.apple.pkpass", fileContent);

                    // File's metadata.
                    File body = new File();
                    body.setTitle("new3.pkpass");
                    body.setMimeType("application/vnd.apple.pkpass");

                    //service.files();
                    File file = service.files().insert(body, mediaContent).execute();
                    if (file != null) {
                        //showToast("Photo uploaded: " + file.getTitle());
                        //startCameraIntent();
                    }
                } catch (UserRecoverableAuthIOException e) {
                    startActivityForResult(e.getIntent(), REQUEST_AUTHORIZATION);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
    */
}
