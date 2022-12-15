package com.kguard.gitlogin

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kguard.domain.DomainRepo
import com.kguard.gitlogin.databinding.ItemRecyclerRepoBinding

class RepoAdapter :ListAdapter<DomainRepo,RepoAdapter.RepoViewHolder>(diffUtil) {
    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<DomainRepo>()
        {
            override fun areItemsTheSame(oldItem: DomainRepo, newItem: DomainRepo): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: DomainRepo, newItem: DomainRepo): Boolean {
                return oldItem.id == newItem.id
            }

        }
    }
    inner class RepoViewHolder(private val binding: ItemRecyclerRepoBinding): RecyclerView.ViewHolder(binding.root)
    {
        fun setItem(domainRepo: DomainRepo)
        {
            binding.id.text=domainRepo.id.toString()
            binding.reponame.text=domainRepo.name
            binding.language.text=domainRepo.language
            binding.isprivate.text=domainRepo.isPrivate.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val binding = ItemRecyclerRepoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RepoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.setItem(getItem(position))
    }
}