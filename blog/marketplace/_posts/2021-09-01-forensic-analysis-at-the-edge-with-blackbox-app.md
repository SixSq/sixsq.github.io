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

[Nuvla](https://nuvla.io/), SixSq's edge-to-cloud platform and marketplace, is built to make your life easy when managing devices and applications at the edge. With the NuvlaEdge software you can turn your ARM or x86 computer into a smart edge device, then install and manage your apps with ease. Now with the added protection of the BlackBox app, you can be sure not to miss anything. 

The BlackBox app records all the data processed by the edge device.  The local storage is on a rotation, and older data is replaced by new data. This will include, for example, video and audio feeds, as well as any other source of data connected to the edge device, such as sensor and machine measurements of all kinds. The diagram below gives an overview of the workflow. 

![blackbox overview](/assets/img/blog/bb-overview2.png)

Figure 1: General overview of the Blackbox.
{: .caption }

### Inbuilt security 

The BlackBox app then automatically archives all the available data. However, before it ships the virtual blackbox to its recipient, it **encrypts** and signs its content to protect any sensitive data it may contain. For the same reason you don't want video and audio feeds to go to the cloud over the wide area network, you don't want the virtual blackbox to leave the edge without **maximum security**.

For this we use asymmetric key encryption. When the BlackBox app is deployed, a public key is used by the app to encrypt the archive. Therefore, only the holder of the private key will be able to decrypt it. SixSq doesn't hold this private key, which makes the overall setup very secure.

The virtual blackbox is then pushed to the cloud where it can be retrieved and analysed. The value of the data contained in the virtual blackbox far outweighs any network and storage costs incurred.

Finally, the user is informed by the notification and alert feature of [Nuvla](https://nuvla.io/). The message includes a direct link to Nuvla which authenticates the user and allows direct download of the virtual blackbox.

Then, using the private key, the user can decrypt the archive and access all the data leading to the significant event that triggered its creation.

![blackbox detailed overview](/assets/img/blog/bb-overview.png)

Figure 2: Detailed view of how the Blackbox creates an archive and sends it.
{: .caption }

### Simple and efficient framework

In terms of architecture, the BlackBox app follows best practices, using a local data bus to organise data inside each edge device. Our NuvlaEdge software is composed of micro services. It includes a message bus service (i.e. MQTT) used by the BlackBox app to collect data. Therefore, as long as other apps push their data (raw or pre-processed) to the message bus, the BlackBox app will be able to add the data to a virtual blackbox archive. The solution is therefore simple, yet efficient, and moreover maintenance free.

Sign up for your free trial of Nuvla [here](https://nuvla.io/ui/sign-up).

Find the BlackBox app in the Nuvla Marketplace [here](https://nuvla.io/ui/sign-in?redirect=apps/sixsq/blackbox), including a complete description, license details and affordable pay-as-you-go pricing. And like all other apps in the marketplace, it can be deployed in a click.

As always, if you need help or have questions along the way, get in touch. 