package com.example.mentorsjoy

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.mentorsjoy.databinding.PdfItemBinding

class PDFAdapter(val listener: Listener):RecyclerView.Adapter<PDFAdapter.PDFHolder>() {
    val pdfList = ArrayList<PdfData>()
    class PDFHolder(item: View):RecyclerView.ViewHolder(item) {
        val binding = PdfItemBinding.bind(item)
        fun bind(pdf: PdfData, listener: Listener) = with(binding){
            textView.text = pdf.getProjectName()
            textView2.text = pdf.getStudentName()
            //binding.imageView2.setIma

            itemView.setOnClickListener {
                listener.onClick(pdf)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PDFHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pdf_item, parent, false)
        return PDFHolder(view)
    }

    override fun getItemCount(): Int {
        return pdfList.size
    }

    override fun onBindViewHolder(holder: PDFHolder, position: Int) {
        holder.bind(pdfList[position], listener)
    }
    fun addPDF(pdf: PdfData){
        pdfList.add(pdf)
        notifyDataSetChanged()
    }
    interface Listener{
        fun onClick(pdfData : PdfData)
    }
}