---
title: Nuvla.io and Kubernetes
product-title: Nuvla and Kubernetes
image: blog_nbe2a.png
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

Throughout its lifetime, the NuvlaEdge software has excelled at supporting businesses and partners in various fields from humanitarian activities to smart cities, open science, earth observation, and much more. 
With it, we have learned that the high demand for small, portable and low energy edge devices is very often incompatible with the resource-demanding nature of the target applications. 
So in addition to Docker, NuvlaEdges can now be deployed via Kubernetes.
Also, applications that are defined via Kubernetes manifests can be deployed to these NuvlaEdges.
All the features and flexibility of Kubernetes are utilized behind the Nuvla.io interface.

## Installation requirements

[prereq]: https://docs.nuvla.io/nuvlaedge/installation/requirements/#prerequisites-when-running-on-k8s-distribution
[helm]: https://helm.sh
[k3s]: https://k3s.io/
[nuvla_doc]: https://docs.nuvla.io/nuvlaedge/installation/install-with-helm/


The [prerequisite][prereq] is for a Kubernetes flavour and [Helm][helm] to be installed.

- The [k3s][k3s] distribution is preferred distribution for foot print and ease of installation and configuration.
- Helm is used for deploying the NuvlaEdge containers.
- The documentation can be found [here][nuvla_doc].

### Footprint


As NuvlaEdge is designed to be run at the edge (giveaway is the name), the resource footprint of the
underlying container orchestration engine (COE) is an important consideration.
In this case we look for a full-feature Kubernetes installation.
Another consideration is the ease of installation of the COE.
Given the requirements for memory, features and installation the [k3s][k3s] distribution is preferred.

The table below follows the methodology as outlined [here][footprint].

[footprint]: https://www.portainer.io/blog/comparing-k0s-k3s-microk8s

![image info](/assets/img/blog/kubernetes_coe_footprint.png "a title")

As can be seen in the table, the footprints are very similar between the COEs.
In fact, the the total memory footprint of k3s is slightly larger than the base k8s COE.
The one-line deployment and one-line addition of worker nodes to a cluster made k3s the
choice for base COE for NuvlaEdge.

## Application deployment

In a manner similar to the Docker NuvlaEdge case, applications can be deployed to Kubernetes NuvlaEdges.
The base requirement is that the application is defined by a YAML Kubernetes manifest.
The manifest may contain multiple Kubernetes "Kinds" e.g. Deployments, Jobs, Services etc.
When an application is deployed in this fashion, the management and life-cycle on the NuvlaEdge
node is managed by the Kubernetes COE.
All the functionality of a NuvlaEdge, as in the Docker case, is available e.g.
update; clone; shutdown/restart; access to log files.
