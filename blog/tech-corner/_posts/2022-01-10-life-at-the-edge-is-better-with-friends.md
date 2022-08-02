---
title: Life at the edge is better with friends
product-title: Life at the edge is better with friends
image: blog_nbe2a.png
breadcrumbs:
 - name: Home
   target: /
 - name: Blog
   target: /blog
 - name: Tech Corner
   target: /blog/tech-corner
tags: edge cloud
blog-category: tech-corner
author: Marc-Elian Bégin
---

### In the midst of social distancing, it is with great excitement that SixSq is introducing the most social NuvlaEdge ever, the v2.0!

Throughout its lifetime, the NuvlaEdge v1 software excelled at supporting businesses and partners in various fields from humanitarian activities to smart cities, open science, earth observation, and much more. With it, we have learned that the high demand for small, portable and low energy edge devices is very often incompatible with the resource-demanding nature of the target applications. But that’s not the only problem with today’s mindset towards Edge Computing.

### Redefining Edge Management

The NuvlaEdgee v2.0 software tackles today’s edge management limitations with innovative features.


![nuvlaedge 2.0](/assets/img/blog/blog_nbe2b.png)


Here are the detailed new key features of the NuvlaEdge v2.0 software:

- Clustering: from Nuvla, you can now instruct a NuvlaEdge powered device to join or leave another NuvlaEdge powered device, thus forming high-availability edge clusters, powered by Container Orchestration Engines
- Networking: when in cluster mode, your NuvlaEdge powered devices will have an off-the-shelf routing mesh and internal DNS services, offered by the underlying Container Orchestration Engine (i.e. Docker Swarm)
- High Availability: with NuvlaEdge clusters, if one NuvlaEdge device goes offline, whatever applications were running inside will automatically be moved to another suitable NuvlaEdge device within the cluster

These features are built on top of an existing Container Orchestration Engine (i.e. Docker Swarm) in the edge device.

### Smaller, Faster and More Powerful

It’s not just about new features. All the old good NuvlaEdge v1 software perks are still there... in fact, most of them have been improved.

For a faster and cleaner installation process, the NuvlaEdge v2 software was refactored with some of the old code merged into fewer components, thus optimising its total core size.

![nbe core size](/assets/img/blog/blog_nbec.png)

Performance was also optimised, making the new NuvlaEdge v2 software the lightest one we have ever created.



![cpu](/assets/img/blog/blog_nbed.png)

### Easier to Install, and More Adaptable to Infrastructure Changes

The NuvlaEdge v1 ssoftware required your edge device to be running in Docker Swarm mode. Well, that’s **not the case anymore** for NuvlaEdge v2. All you need is Docker Compose for the installation, and then the NuvlaEdge v2 ssoftware will adapt itself to the underlying host environment, whether that is a standalone Docker machine, or a Swarm cluster node.

What's not to like? If you want to dive into the details, take a look at our [NuvlaEdge documentation](https://docs.nuvla.io/nuvlabox/).  For a demo or more information about how the NuvlaEdge software can transform your activity at the edge, get in touch.
