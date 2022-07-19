---
title: Data Management with Nuvla.io Part 3
product-title: Data Management with Nuvla.io Part 3
image: edge-to-cloud-big-data.png
breadcrumbs:
 - name: Home
   target: /
 - name: Blog
   target: /blog
 - name: Tech Corner
   target: /blog/tech-corner
tags: edge cloud toto
blog-category: tech-corner
author: Konstantin Skaburskas
---

#### Implementing a successful edge computing strategy requires close cooperation between software developers and IT operations.  Adopting DevOps principles is therefore the natural way to go. In this blog, we explore how the Nuvla.io application management platform enables you to extend your DevOps workflow to the edge.


## Benefits of DevOps 

DevOps is not a new concept. Far from it. For a little over ten years now, this endearing set of best practices has been making its way into every software development and IT operations team worthy of its name.

In fact, a [DevOps report from 2019](https://cloud.google.com/devops/state-of-devops/) studied and gathered statistics on how this set of Agile practices makes a difference between teams who adopt it and those who don’t:

![devops stats](/assets/img/blog/devopsstats.png)

In short, teams who adopt DevOps are in general more productive, deliver more reliable products, and do all of that much faster.

## Continuous Integration & Delivery is key

One of the biggest DevOps tactics is called CI/CD, which stands for Continuous Integration and Continuous Delivery/Deployment. Its purpose is to integrate a trustworthy and automated chain of testing marks into the Agile development process.

For the sake of simplicity, let’s take the following DevOps workflow:

![devops](/assets/img/blog/devops2.jpeg)


The Continuous Integration phase consists of everything from planning to coding, building and testing (pretty much the left part of the diagram above). This is where all the automated tests are executed against every new code change, and where your software is compiled and/or built.

Continuous Delivery/Deployment comes after that, by releasing the committed software, and in some cases, deploying it into a QA environment for validation (for example for Canary deployments). 

## What does Nuvla.io have to do with all of this?

Being able to continuously deploy your software across a fleet of edge devices sounds ideal. However, most software houses lack the ability to consistently deploy software on edge computing infrastructures. They typically have a large backlog of updates waiting to be manually deployed. This is where Nuvla.io can help. To get started with Nuvla.io you only need to:

- register with Nuvla.io and set up your environment 
- prepare your edge device by installing the NuvlaBox Engine software
- add your containerised app to Nuvla.io

Our [documentation](https://docs.nuvla.io/) will support you along the way. And if you hit a snag, simply reach out to us via the little blue widget on the bottom right of any of our websites.

## Developers, read on ⬇️

Well, DevOps without tooling would be quite complicated. You’ll easily find a plethora of tools for each step of the DevOps process: Issue Trackers and Scrum Boards for planning (like JIRA), IDEs for coding (like IntelliJ), Source Code Management systems for tracking changes (like GitHub), Continuous Testing applications for testing code changes (like Jenkins and GitHub CI), Continuous Deployment tools for automatic provisioning (like ArgoCD), etc.

So, if you think about it, since Nuvla.io is basically an application management platform with orchestration capabilities for Docker and Kubernetes environments, why not use it for Continuous Deployment?

![cicd](/assets/img/blog/nuvlacicd.png)

So let’s say you plan for a new feature. An awesome one by the way. First, you develop it. Your code looks neat and tidy, so you commit it. When you commit, your continuous tests will be triggered, and they’ll run all the unit and integration tests to validate that your feature is working properly. And it is, so congrats! Upon this successful step, you will also have another action that will build and push your new code as an artefact (let’s say your final artefact is a Docker Image in Docker Hub). Finally, you want to roll out this new feature to all of your ongoing deployments (be it QA or production). So instead of doing this roll-out manually, why not simply trigger a new continuous action, that will use Nuvla.io’s REST API to deploy your new application (that is registered in your Nuvla.io App Store) into your infrastructures (also registered in Nuvla.io)?

This will give you transparent and infrastructure-agnostic deployments in any compute infrastructure (at the edge or in the cloud), plus you’ll be able to then operate and monitor the lifecycle of your deployments from the Nuvla.io platform!

## Example of CD using Nuvla.io

To help you integrate Nuvla.io into your CI/CD pipeline, we at SixSq have built a GitHub Action that you can use to automatically deploy an app from Nuvla.io into an infrastructure.

This GitHub Action is called Nuvla Application Deployer and is available in the GitHub marketplace at [https://github.com/marketplace/actions/nuvla-application-deployer](https://github.com/marketplace/actions/nuvla-application-deployer).

To use it, simply make sure your GitHub repositories has the GitHub Actions enabled. In your GitHub Actions Workflow, you can use our Nuvla Application Deployer as a job. Something like this:



```
Jobs: continuous-deployment: 

runs-on: ubuntu-latest
name: Deploy application from Nuvla.io steps: 

- name: Deploy
id: deploy
uses: nuvla/nuvla-deploy-app-action@v1 with: 

api-key: $ api-secret: $ module-id: 'module/<uuid>'
credential-id: 'credential/<uuid>' environment: 'NUVLABOX_UUID=nuvlabox/<uuid>' 
```

# Use the output
- name: Get the output 

run: echo "The output was $"  



Looks quite straightforward, right? Just to make sure it's all clear, let’s go through each action input:

- api-key and api-secret: to manage resources in Nuvla.io, you need to be [registered as a user](https://nuvla.io/ui/sign-up). This GitHub Action will perform an operation on your behalf, so it needs a valid credential for login
- module-id: you are trying to deploy an application that you, or someone else, have previously registered in Nuvla.io. If you click on this application, you’ll find an underlying module ID that the GitHub Action will need in order to know which app to deploy.
- credential-id: Nuvla.io speaks with infrastructures via their secure API (Docker or Kubernetes). This means all of your infrastructures in Nuvla.io should have at least one Container Orchestration Engine Credential associated with it. This ID will tell GitHub Action which credential to use when deploying your app in the infrastructure. You can find this credential from the Credentials page in Nuvla.io.
- environment: finally, this optional input lets you define environment variables for your application. Assuming your Nuvla.io app has been configured to accept these variables, all you need to do is to provide them to the GitHub Action, as a comma-separated string, making sure the variable names match with the ones in the corresponding Nuvla.io application.

If the action fails, it will try to auto-clean whatever deployments have been started, otherwise, on success, it will output the ID of your deployment, which you can capture via the workflow variable:

steps.test.outputs.DEPLOYMENT_ID 


Now you can manage the lifecycle of your edge applications much more easily.

Continuous Deployment is just one of the many benefits of using Nuvla.io.  There are several ways you can dig deeper, so why not take a look then contact us if you need a helping hand? And we are always interested to hear about your experience. So don't hesitate to get in touch.