package org.ligi.passandroid.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

class ExportProblemPassToLigiAndFinishTask extends PassExportTask {

    private final Activity activity;

    public ExportProblemPassToLigiAndFinishTask(Activity activity, String path, String zip_path, String zip_fname) {
        super(activity, path, zip_path, zip_fname, false);
        this.activity = activity;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        Intent it = new Intent(Intent.ACTION_SEND);
        it.putExtra(Intent.EXTRA_SUBJECT, "a Passbook with a problem");
        it.putExtra(Intent.EXTRA_EMAIL, new String[]{"ligi@ligi.de"});
        it.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://" + zipPath + zipFileName));
        //it.setType("application/vnd.apple.pkpass");
        it.setType("plain/text");
        it.putExtra(Intent.EXTRA_TEXT, "");

        ctx.startActivity(Intent.createChooser(it, "How to send Pass?"));

        activity.finish();

    }
}
