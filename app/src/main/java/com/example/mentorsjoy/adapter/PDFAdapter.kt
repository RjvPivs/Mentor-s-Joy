package com.example.mentorsjoy.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mentorsjoy.R
import com.example.mentorsjoy.databinding.PdfItemBinding
import com.example.mentorsjoy.model.PdfData

class PDFAdapter(val listener: Listener):RecyclerView.Adapter<PDFAdapter.PDFHolder>() {
    val pdfList = ArrayList<PdfData>()
    class PDFHolder(item: View):RecyclerView.ViewHolder(item) {
        val binding = PdfItemBinding.bind(item)
        fun bind(pdf: PdfData, listener: Listener) = with(binding){
            textView.text = pdf.getProjectName()
            textView2.text = pdf.getStudentName()
            //binding.imageView2.setIma
            itemView.setOnClickListener {
                listener.onClickMove(pdf)
            }
            imageDelete.setOnClickListener{
                listener.onClickDel(pdf)
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
    fun clear(){
        pdfList.clear()
    }
    override fun onBindViewHolder(holder: PDFHolder, position: Int) {
        holder.bind(pdfList[position], listener)
    }
    @SuppressLint("NotifyDataSetChanged")
    fun addPDF(pdf: PdfData){
        pdfList.add(pdf)
        notifyDataSetChanged()
    }
    @SuppressLint("NotifyDataSetChanged")
    fun delete(pdf: PdfData){
        pdfList.remove(pdf)
        notifyDataSetChanged()
    }
    interface Listener{
        fun onClickMove(pdfData : PdfData)
        fun onClickDel(pdf: PdfData)
    }
}