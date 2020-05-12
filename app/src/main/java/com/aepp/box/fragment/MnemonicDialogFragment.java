package com.aepp.box.fragment;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;

import com.aepp.box.R;
import com.google.android.material.button.MaterialButton;
import com.pep.core.libbase.EasyBaseDialogFragment;
import com.pep.core.uibase.EasyToast;

import me.codeboy.android.aligntextview.CBAlignTextView;

/**
 * @author sunbaixin QQ:283122529
 * @name Box-aepp-Android
 * @class name：com.aepp.aeasy_sdk_library.fragments
 * @class describe
 * @time 2020-04-11 17:48
 * @change
 * @chang time
 * @class describe
 */
public class MnemonicDialogFragment extends EasyBaseDialogFragment {

    private String mnemonic;
    private CBAlignTextView tvMnemonic;
    private MaterialButton mbCopy;
    private MaterialButton mbRemember;


    private DialogInterface.OnDismissListener onDismissListener;

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.onDismissListener = onDismissListener;
    }

    @Override
    protected int getAnimateStart() {
        return Gravity.TOP;

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_dialog_mnemonic;
    }

    @Override
    public void initView() {
        tvMnemonic = (CBAlignTextView) findViewById(R.id.tv_mnemonic);
        mbCopy = (MaterialButton) findViewById(R.id.mb_copy);
        mbRemember = (MaterialButton) findViewById(R.id.mb_remember);
    }


    @Override
    public void initData() {
        if (getArguments() != null) {
            mnemonic = (String) getArguments().get("mnemonic");
        }
        if (!TextUtils.isEmpty(mnemonic)) {
            tvMnemonic.setText(mnemonic);
        }

        mbCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取剪贴板管理器：
                ClipboardManager cm = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                // 创建普通字符型ClipData
                ClipData mClipData = ClipData.newPlainText("Label", mnemonic);
                // 将ClipData内容放到系统剪贴板里。
                cm.setPrimaryClip(mClipData);
                EasyToast.show(getContext(),"Copy Sucess");

            }
        });
        mbRemember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (onDismissListener != null) {
                    onDismissListener.onDismiss(null);
                }

            }
        });

        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override


            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    return true;
                }
                return false;
            }

        });
    }


}
