---
title: Nuvla.io and Kubernetes
product-title: Nuvla.io and Kubernetes
image: kubernetes-vignette.png
no-image: true
product-background-img: bg-hero-kubernetes.png
breadcrumbs:
 - name: Home
   target: /
 - name: Blog
   target: /blog
 - name: Tech Corner
   target: /blog/tech-corner
tags: edge cloud kubernetes
blog-category: tech-corner
author: John White
---

# Nuvla.io now supports deployment via Kubernetes

One of the [advantages of edge computing](/blog/discover/2022/05/03/4-ways-to-know-if-you-need-edge-computing.html) is that you can collect, process and store data near its source, in factories, shops, warehouses, energy plants, in fact anywhere you need a better understanding of what is going on in your business or organisation. As is the nature of such locations, this often requires the use of small, portable and low energy devices.  As is the nature of business, we constantly expect better, faster and easier to use edge intelligence, including AI algorithms running at the edge, improved resource consumption and so on. 

In these situations, hardware becomes the limiting factor. Small devices cannot host the increasingly resource-demanding applications required by business, so we have to look for clever software solutions.  For that reason, SixSq's [NuvlaEdge](/nuvlaedge) software has been container-ready and Docker-friendly since the outset. Responding to the requirements of a wide range of customers, from fields as diverse as humanitarian work, smart cities, open science and earth observation, the SixSq team is pleased to announce that NuvlaEdges can now also be deployed via the [Kubernetes](https://kubernetes.io/) "family". Kubernetes brings **more functionality and security**, improved load balancing and resilience. Applications that are defined via Kubernetes manifest files can be deployed to NuvlaEdges. All the features and flexibility of Kubernetes are utilised behind the Nuvla.io interface, making it easier for you to deploy.

Now we'll dive into the details of how you can leverage this improved deployment feature. ⬇️

## Installation requirements

[prereq]: https://docs.nuvla.io/nuvlaedge/installation/requirements/#prerequisites-when-running-on-k8s-distribution
[helm]: https://helm.sh
[k3s]: https://k3s.io/
[nuvla_doc]: https://docs.nuvla.io/nuvlaedge/installation/install-with-helm/


The [prerequisite][prereq] is for a Kubernetes flavour and [Helm][helm] to be installed.

- The [k3s][k3s] distribution is preferred distribution when considering memory footprint and ease of installation and configuration.
- Helm is used for deploying the NuvlaEdge containers.
- The documentation can be found [here][nuvla_doc]

### Footprint

As NuvlaEdge is designed to be run in devices at the computing edge (giveaway is in the name), the resource footprint of the
underlying Container Orchestration Engine (COE) is an important consideration.
In this case we look for a full-feature Kubernetes installation.
Another consideration is the ease of installation of the COE.
Given the requirements for memory, features and installation the [k3s][k3s] distribution is preferred.

The table below follows the methodology as outlined [here][footprint]

[footprint]: https://www.portainer.io/blog/comparing-k0s-k3s-microk8s

![image info](/assets/img/blog/kubernetes_coe_footprint.png "a title")

As can be seen in the table, the memory footprints are very similar between the COEs.
In fact, the the total memory footprint of k3s is slightly larger than the base k8s COE.
The main factor in selecting the [k3s][k3s] distribution as the recommended COE for NuvlaEdge 
is the extremely easy one-line deployment and subsequent configuration steps.

## Application deployment

In a manner similar to the Docker NuvlaEdge case, applications can be deployed to Kubernetes NuvlaEdges.
The base requirement is that the application is defined by a Kubernetes YAML manifest.
The manifest may contain multiple Kubernetes "Kinds" e.g. Deployments, Jobs, Services etc.
When an application is deployed in this fashion, the management and life-cycle on the NuvlaEdge
node is managed by the Kubernetes COE.
All the functionality of a NuvlaEdge, as in the Docker case, is available e.g.
update; clone; shutdown/restart; access to log files.

## Learn more

[Video](https://youtu.be/yqly8M_l2Cs) on how to get started with Nuvla.io 

[NuvlaEdge tech specs](https://sixsq.com/nuvlaedge#techspecs)

[NuvlaEdge certified hardware](https://sixsq.com/nuvlaedge#hardware)
