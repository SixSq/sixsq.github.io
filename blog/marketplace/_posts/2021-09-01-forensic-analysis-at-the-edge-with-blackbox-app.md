---
title: Forensic analysis at the edge with the blackbox app
product-title: Forensic analysis at the edge with the blackbox app
image: blackbox-blog-title-min.png
breadcrumbs:
 - name: Home
   target: /
 - name: Blog
   target: /blog
 - name: Tech Corner
   target: /blog/tech-corner
tags: edge cloud toto
blog-category: tech-corner
author: Marc-Elian Bégin
---

#### Edge computing systems work in a semi-autonomous way, which is great for providing fast responses, no privacy intrusion and reduced costs from network and cloud storage. But when an incident occurs, you want to archive to the cloud as much data as possible to give you insights into what led to this incident: enter the Blackbox app.

### Protecting critical data

When an aeroplane crashes, we need to know what happened, not least to prevent the same thing from happening again. The onboard blackbox is crucial in this case as it contains data that will help solve the puzzle.

During normal operations, applications running at the edge are autonomous and go about their business processing data. From this data, only valuable information is transferred to the cloud, delivering the network and storage cost savings that we love about edge computing. Suddenly, a significant event occurs. This could be a critical failure, a crash, an accident or a cyber attack. Then we need the relevant recent data to be archived and protected, just like in an aeroplane. This requirement motivated SixSq Software Engineer [Lionel Schaub](https://www.linkedin.com/in/lionel-s-65a44459/) to develop the BlackBox app.

The BlackBox app kicks in when a significant event is detected. It creates an encrypted **virtual blackbox**, containing all the data it can lay its hands on, and ships it to the cloud for forensic analysis.

### How it works

[Nuvla.io](https://nuvla.io/), SixSq's edge-to-cloud platform and marketplace, is built to make your life easy when managing devices and applications at the edge. With the NuvlaBox Engine software you can turn your ARM or x86 computer into a smart edge device, then install and manage your apps with ease. Now with the added protection of the BlackBox app, you can be sure not to miss anything. 

The BlackBox app records all the data processed by the edge device.  The local storage is on a rotation, and older data is replaced by new data. This will include, for example, video and audio feeds, as well as any other source of data connected to the edge device, such as sensor and machine measurements of all kinds. The diagram below gives an overview of the workflow. 

![cicd](/assets/img/blog/nuvlacicd.png)
