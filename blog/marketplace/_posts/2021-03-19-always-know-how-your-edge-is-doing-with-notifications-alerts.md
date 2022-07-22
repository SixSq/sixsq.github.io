---
title: Always know how your edge is doing with notifications and alerts
product-title: Always know how your edge is doing with notifications and alerts
image: hermes-min.png
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

#### Don't stress about the state of your fleet of edge computing devices or your edge system. Instead, depend on a reliable alert and notification system which tells you when your edge requires your attention, or if everything is good.

### Never miss a beat at the edge

Edge IoT devices are taking the world of IT by storm. They are deployed in a wide range of sectors and markets, ensuring efficient infrastructure management, where analytics is deployed close to the data, instead of moving a huge amount of data to the cloud.

As you scale your fleet of edge devices, you want to know that everything is going well, and if not, you want be told right away so that you can address the issue. You also want to make sure that there are no trigger-happy notifications, which could result in your organisation wasting precious time chasing red herrings.

On the apps side, as you deploy them from your App Store or Marketplace, you also want to ensure updates are taking place and you're running the right app at the right place and the right time. 

At SixSq, we have been working on a “notification” feature able to fulfil this precise need.  Working with early adopters, we have found what we believe to be the right balance in terms of how alerts are defined and detected, as well as the most convenient way to deliver these alerts.

Using [Nuvla.io](https://nuvla.io/) edge management platform, users can now simply register alerts on a number of metrics, such as:

1. When a device goes offline and when it comes back online
2. Threshold on telemetry values, for example:
- 	when disk space goes low,
- 	memory usage is too high, or
- 	CPU usage excessively high 

And by default, as more edge devices are added, notifications will also also apply to these new devices, making maintenance of alerts a breeze.  Further, notifications can be defined to only alert on a subset of edge devices - e.g. all NuvlaEdge powered devices located in Germany, or from a specific customer or located in a given plant, harbour or airport.

This applies to any edge device running the NuvlaEdge software. If you haven't installed the NuvlaEdge software on your edge devices yet, we'd be happy to help.

![slack alert](/assets/img/blog/slack-alert.png)

Example of email notification - NuvlaEdge back online.
{: .caption }

In terms of delivery mechanism, we have enabled email and Slack.  But if you’re missing your favourite delivery tool, please get in touch and we’ll be more than happy to add more delivery methods.

![slack alert](/assets/img/blog/email-alert-1.png)

Example of Slack notification - NuvlaEdge offline.
{: .caption }

[Konstantin Skaburskas](https://www.linkedin.com/in/konstantinskaburskas/) led the charge on our side.  Behind the scenes this new feature is based on a new infrastructure service leveraging the Kafka open source software, which is scalable and robust. This also means that [Nuvla.io](https://nuvla.io/) now offers enterprise customers a new event driven interface, such that it can securely be integrated into their overall IT eco-system.

As with everything we do at SixSq, we’re really focused on user and customer feedback.  So let us know how this feature works for you, how we can improve it and evolve it. We’re already looking into exposing this feature to app developers, to allow them to leverage our notification feature and its reliable alert and delivery capabilities from their edge app. So stay tuned.