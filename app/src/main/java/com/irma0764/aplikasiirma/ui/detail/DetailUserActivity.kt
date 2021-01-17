package com.irma0764.aplikasiirma.ui.detail


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.irma0764.aplikasiirma.R
import com.irma0764.aplikasiirma.databinding.ActivityDetailUserBinding
import com.irma0764.aplikasiirma.databinding.FragmentFollowBinding
import com.irma0764.aplikasiirma.ui.main.MainAdapter

class DetailUserActivity : AppCompatActivity() {
    companion object {
        const val USERNAME = "username"
    }

    private lateinit var binding: ActivityDetailUserBinding
    private lateinit var viewModel: DetailUserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(USERNAME)
        val bundle = Bundle()
        bundle.putString(USERNAME, username)

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(DetailUserViewModel::class.java)

        username?.let { viewModel.setUserDetail(it) }
        viewModel.getUserDetail().observe(this, {
            if (it != null) {
                binding.apply {
                    tvName.text = it.name
                    tvUsername.text = it.login
                    tvFollowers.text = "${it.followers} Followers"
                    tvFollowing.text = "${it.following} Following"

                    Glide.with(this@DetailUserActivity)
                        .load(it.avatar_url)
                        .into(tvProfile)
                }
            }
        })

        val sectionPagerAdapter = SectionPagerAdaptor(this, supportFragmentManager, bundle)
        binding.apply {
            viewPager.adapter = sectionPagerAdapter
            tabs.setupWithViewPager(viewPager)
        }

    }
}