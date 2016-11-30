package io.haydar.we;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Created by gjy on 2016/11/30.
 */

public class WebViewEmptyViewClient extends WebViewClient {
    private Context mContext;
    private ViewStub mLoadViewStub, mErrorViewStub;
    private boolean isError = false;
    private int mErrorLayout, mErrorLayoutId, mLoadLayout, mLoadLayoutId;

    public WebViewEmptyViewClient(Context context) {
        this(context, R.layout.view_error, R.id.error_layout, R.layout.view_load, R.id.load_layout);
    }

    public WebViewEmptyViewClient(Context context, int mErrorLayout, int mErrorLayoutId, int mLoadLayout, int mLoadLayoutId) {
        this.mContext = context;
        this.mErrorLayout = mErrorLayout;
        this.mErrorLayoutId = mErrorLayoutId;
        this.mLoadLayout = mLoadLayout;
        this.mLoadLayoutId = mLoadLayoutId;
    }


    @Override
    public void onReceivedError(final WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
        if (mErrorViewStub == null) {
            mErrorViewStub = new ViewStub(mContext);
            mErrorViewStub.setInflatedId(mErrorLayoutId);
            mErrorViewStub.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            mErrorViewStub.setLayoutInflater(LayoutInflater.from(mContext));
            mErrorViewStub.setLayoutResource(mErrorLayout);
            mErrorViewStub.setClickable(true);
            view.addView(mErrorViewStub);

            View errorView = mErrorViewStub.inflate();
            errorView.findViewById(R.id.error_layout).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    view.reload();
                }
            });
        } else {
            mErrorViewStub.setVisibility(VISIBLE);
        }
        isError = true;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        if (mLoadViewStub == null) {
            mLoadViewStub = new ViewStub(mContext);
            mLoadViewStub.setInflatedId(mLoadLayoutId);
            mLoadViewStub.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            mLoadViewStub.setLayoutInflater(LayoutInflater.from(mContext));
            mLoadViewStub.setLayoutResource(mLoadLayout);
            view.addView(mLoadViewStub);
            mLoadViewStub.inflate();
        } else {
            mLoadViewStub.setVisibility(VISIBLE);
        }
        isError = false;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        mLoadViewStub.setVisibility(GONE);
        if (!isError && mErrorViewStub != null)
            mErrorViewStub.setVisibility(GONE);
    }

}
