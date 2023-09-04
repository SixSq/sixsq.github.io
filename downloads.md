---
layout: downloads
title: Downloads
product-title: Downloads
product-description: Download documents, 1-pagers, technical specifications and more.
product-background-img: bg-hero-Resources.jpg
breadcrumbs:
 - name: Home
   target: /
without-trial: true
they-trust-us: false
redirect_from:
 - /download
---

<div class="container-fluid">
    <div class="container section text-center hero-narrow">
        <div id="products" class="anchor-position"></div>
        <div class="row row-col-feature row-col-feature-logo">
          {% for download in site.downloads %}
            {% include download-card.html %}
          {% endfor %}
          
            <div class="col-lg-6">
                <div class="shadow">
                    <img src="/assets/img/icon-news.svg">
                    <h3>Logistics </h3>
                    <p>Discover the latest news and events from SixSq, our partners and customers.</p><a class="btn btn-light" role="button" href="/news" target="_blank">Read news</a>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="shadow">
                    <img src="/assets/img/icon-blog.svg">
                    <h3>Blog</h3>
                    <p>We share in this blog our latest thoughts and what we've learned working with partners and customers.</p><a class="btn btn-light" role="button" href="/blog" target="_blank">Read articles</a>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="shadow">
                    <img src="/assets/img/icon-video.svg">
                    <h3>Videos</h3>
                    <p>See us in action&colon; talking, showing, explaining and evangelising about edge computing, cloud computing and what we do.</p><a class="btn btn-light" role="button" href="/videos" target="_blank">Watch now</a>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="shadow"><img src="/assets/img/icon-documents.svg">
                    <h3>Documentation</h3>
                    <p>If you're the reading type, our documentation website is designed for you.</p><a class="btn btn-light" role="button" href="https://docs.nuvla.io/" target="_blank">Read on</a>
                </div>
            </div>
        </div>
        <!-- <div class="row row-col-feature row-col-feature-logo">
            <div class="col-lg-4">
                <div class="shadow"><img src="/assets/img/icon-Webinar.svg">
                    <h3>Webinar</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore.</p><a class="btn btn-light" role="button" href="https://nuvla.io/">Watch now</a>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="shadow"><img src="/assets/img/icon-knowledge.svg">
                    <h3>Edge Knowledge Base</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore.</p><a class="btn btn-light" role="button" href="https://nuvla.io/">Read articles</a>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="shadow"><img src="/assets/img/icon-documents.svg">
                    <h3>White papers</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore.</p><a class="btn btn-light" role="button" href="https://nuvla.io/">Learn more</a>
                </div>
            </div>
        </div> -->
    </div>
</div>
