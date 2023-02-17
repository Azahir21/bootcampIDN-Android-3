package com.bootcamp.tugas3_bootcampidn

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.tugas3_bootcampidn.databinding.ItemRowNewsBinding
import com.bootcamp.tugas3_bootcampidn.model.ArticlesItem
import com.bumptech.glide.Glide

class NewsAdapter(private var newsList: List<ArticlesItem>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    inner class NewsViewHolder(private val binding: ItemRowNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: ArticlesItem) {
            binding.apply {
                tvJudul.text = data.title
                tvPenulis.text = data.author
                tvTanggalPosting.text = data.publishedAt

                Glide.with(imgNews)
                    .load(data.urlToImage)
                    .error(R.drawable.ic_launcher_background)
                    .into(imgNews)

                binding.cardNews.setOnClickListener {
                    val intent = Intent(itemView.context, DetailNewsActivity::class.java)
                    intent.putExtra(DetailNewsActivity.EXTRA_NEWS, data)//newsList[position]
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val rowBinding = ItemRowNewsBinding.inflate(layoutInflater, parent, false)
        return NewsViewHolder(rowBinding)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        return holder.bind(newsList[position])
    }
    fun setData(data: List<ArticlesItem> ){
        newsList = data
        notifyDataSetChanged()
    }
}