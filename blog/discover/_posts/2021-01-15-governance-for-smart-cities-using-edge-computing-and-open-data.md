---
title: Governance for smart cities using edge computing and open data
product-title: Governance for smart cities using edge computing and open data
image: governance-min.png
breadcrumbs:
 - name: Home
   target: /
 - name: Blog
   target: /blog
tags: edge cloud
author: Marc-Elian Bégin
---

**Citizens and innovators increasingly demand open data, that anyone can access, use and share, to better understand how the city pulses and improve policy decisions.  An effective, secure, non-intrusive and flexible way of providing open data is to leverage edge computing. Edge computing provides a way to deploy realtime services, that avoid data intrusion issues, while enabling an evolutive approach for the city. However, in order to scale and deliver its full innovation potential, edge computing and open data must form the integral part of a governance policy. This blog explores some of the aspects such a governance policy must address and how.**

### Governance for what?
In previous blog post, we looked at the key drivers for adopting edge computing. In, another blog post, we explored how different sensors (e.g. audio and video) can be combined and reused at the edge.  Edge computing has the ability to transform raw data, such as audio and video streams, into information (e.g. "there's an accident") in real-time (here and now). Further, edge computing can produce trending information (e.g. traffic peak and averages, over time, by vehicle category), which can then be aggregated in the cloud (local/private or public) and published as open data. This open data can then be used by a range of users, both public and private, including organisations and citizens.

However, in order to ensure that only curated data is available as open data, robust and clear governance is required.

Here are some of the areas a smart city governance policy should address to provide trusted open data and edge computing:

- Applications 
- Data
- Access
- Sensors 

Let's take a closer look at each of these items, and how governance can be achieved.

#### Applications
Edge management platforms, such as Nuvla.io, include the concept of an app store, from which operators of the edge infrastructure can deploy a range of applications. However, in a smart city context, it is paramount that only safe and secure applications are deployed on its edge infrastructure. Therefore, an application certification process must be put in place.

Such an edge application policy could include, for example, that the application only communicates data to the city open data storage. Or that detected events are only sent to recognised authorities.  Another important point could be that apps don't forward any data or information which intrudes into a citizen's privacy.

A pragmatic way to start upon an app certification processes could be to inspect and test each application. Once the app is certified, it can then be granted the appropriate rights, such that the smart city edge operator can deploy it.

####  Data
Another important aspect of governance should relate to the type of information transferred to the cloud and included as open data. For example, ensuring that only trend information, such as aggregated averages, minimum and maximum values over time, is good and simple start.  For traffic data this is how it could look like:

min, max and average vehicle every 10 mins, for each measurement location, 
categorisation of vehicles percentage of the same time period.
What should not be included is any data that could identify an individual, either directly (e.g. voice or image) or indirectly (e.g. unique identifier that could be used to identify an individual over time).

In our previous blog on data fusion, we explore how forensic data can be used to assist enquiries (e.g. video and audio stream of an accident), but to be clear, this type of data should never be confused with open data. Forensic data should be encrypted and only delivered to authorities able to decrypt it, and under strict conditions. The beauty of an edge management platform is that it allows all of this fine tuning to take place.

#### Access
Controlling who has access to the management functions of the system is also paramount. To this end, management platforms, such as Nuvla.io, have advanced authorisation features, ensuring only members of a given group are allowed to perform specific actions. It is therefore straightforward to configure the edge infrastructure devices to only be available to users in a certain group.

Further, all important actions are logged, thus leaving an audit trail. This can then be used by any controlling authority to review what actions were performed, by whom and when.

On the applications side, only certified application versions should be available to the group managing the edge infrastructure, such that only these are deployed and updated. 

####  Sensors
What type of sensors can be used is another aspect an edge computing governance policy should consider. When correctly implemented, edge computing means sensors can be isolated. For example, if the only path to the network for a sensor is via the edge device it is attached to, it means it is not be able to reach out to unknown services on the wide area network. This means a wider range of sensors could be used safely, since any network route would end in the secure edge device.  And since we have fine control over how each edge device communicates, we can ensure that no backdoor is present. This can significantly reduce costs by widening the palette of sensors that can be deployed.

Open Data exploitation
Once the system is in place, users will be able to access clean, safe, valuable and reliable information, in the form of curated data, produced by fleets of edge devices.

Looking at our traffic data example, this means that users would be able to query the open data system to extract trending information, such as:

- traffic highs and lows over days, during week days vs weekends, school holidays vs working days.
- proportion of trucks vs cars vs bicycles vs pedestrians across the city to understand usage pattern.
- impact on traffic across events such as accidents, road works or speed reduction experiments.

This could be replicated for each and every data set gathered across the city. The transformative impact of having readily available data, refreshed constantly, is potentially significant. And as more data sets are added to the system, e.g. air quality measurements, noise level, light intensity and energy consumption, the better the understanding of all stakeholders.

#### Bringing it all together
In this blog, we have sketched out an outline of what a smart city governance policy could look like, to ensure all stakeholders can reap the benefits of edge computing and open data, safely, and with sufficient agility to evolve with the city's future needs.

Adding a certification process to edge platforms such as Nuvla.io enhances the value of the **app marketplace**. This means application vendors could register edge (and cloud) applications, allowing cities to deploy these apps with confidence.  This is a powerful concept that will allow smart city operators and application developers to work together to improve services and innovate.

Our objective is for this post to be used as a trigger towards the elaboration of a governance policy that can be tested in real life, over a real edge infrastructure, in real-life conditions. Of course, if you are interested in this process, please get in touch.

