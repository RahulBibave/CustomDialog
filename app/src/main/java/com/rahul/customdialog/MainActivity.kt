package com.rahul.customdialog

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_success_dialog.*
import kotlinx.android.synthetic.main.layout_success_dialog.view.*
import kotlinx.android.synthetic.main.layout_success_dialog.view.imgIcon
import kotlinx.android.synthetic.main.layout_success_dialog.view.txtMessage
import kotlinx.android.synthetic.main.layout_success_dialog.view.txtTitle
import kotlinx.android.synthetic.main.layout_warning_dialog.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSuccess.setOnClickListener {
            showSuccessDialog()
        }

        btnWarning.setOnClickListener {
            showWarningDialog()
        }

        btnError.setOnClickListener {
            showErrorDialog()
        }
    }

    private fun showSuccessDialog(){
        val builder=AlertDialog.Builder(this,R.style.AlertDialog)
        val view=LayoutInflater.from(this).inflate(R.layout.layout_success_dialog,layoutDailogContainer)
        builder.setView(view)
        view.txtTitle.text=resources.getString(R.string.success_title)
        view.txtMessage.text=resources.getString(R.string.dummy_text)
        view.btnAction.text=resources.getString(R.string.okay)
        view.imgIcon.setImageResource(R.drawable.ic_success)
        val alertDialog=builder.create()
        view.btnAction.setOnClickListener {
            alertDialog.dismiss()
        }
        if (alertDialog.window !=null){
            alertDialog.window!!.setBackgroundDrawable(ColorDrawable(0))
        }
        alertDialog.show()
    }

    private fun showWarningDialog(){
        val builder=AlertDialog.Builder(this,R.style.AlertDialog)
        val view=LayoutInflater.from(this).inflate(R.layout.layout_warning_dialog,layoutDailogContainer)
        builder.setView(view)
        view.txtTitle.text=resources.getString(R.string.warning_title)
        view.txtMessage.text=resources.getString(R.string.dummy_text)
        view.btnYes.text=resources.getString(R.string.yes)
        view.btnNo.text=resources.getString(R.string.no)
        view.imgIcon.setImageResource(R.drawable.ic_warning)
        val alertDialog=builder.create()
        view.btnYes.setOnClickListener {
            alertDialog.dismiss()
            Toast.makeText(this,"yes",Toast.LENGTH_LONG).show()
        }
        view.btnNo.setOnClickListener {
            alertDialog.dismiss()
            Toast.makeText(this,"No",Toast.LENGTH_LONG).show()
        }
        if (alertDialog.window !=null){
            alertDialog.window!!.setBackgroundDrawable(ColorDrawable(0))
        }
        alertDialog.show()
    }

    private fun showErrorDialog(){
        val builder=AlertDialog.Builder(this,R.style.AlertDialog)
        val view=LayoutInflater.from(this).inflate(R.layout.layout_error_dialog,layoutDailogContainer)
        builder.setView(view)
        view.txtTitle.text=resources.getString(R.string.error_title)
        view.txtMessage.text=resources.getString(R.string.dummy_text)
        view.btnAction.text=resources.getString(R.string.okay)
        view.imgIcon.setImageResource(R.drawable.ic_error)
        val alertDialog=builder.create()
        view.btnAction.setOnClickListener {
            alertDialog.dismiss()
        }
        if (alertDialog.window !=null){
            alertDialog.window!!.setBackgroundDrawable(ColorDrawable(0))
        }
        alertDialog.show()
    }
}
