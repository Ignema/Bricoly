# <span style="color: #A3B4F2; font-size: 2.6rem; font-weight: bolder;">Bricoly</span> <span style=" font-size: 2.4rem;"> : Engineer Your Life The Way It Should Be...</span>

<p align="center">
<img src="https://raw.githubusercontent.com/Ignema/Bricoly/master/res/Bricoly-Icon.png?token=GHSAT0AAAAAABQA32QBVCMLGDZDQNEBXNDGYQQNT4Q" width="auto" height="160" />
<img src="https://raw.githubusercontent.com/Ignema/Bricoly/master/res/Bricoly.png?token=GHSAT0AAAAAABQA32QBP6YP6LUPO6QK2TSAYQQNUHQ" width="auto" height="140" />
</p>

## 📘 Description

This project's aims to connect people who are able to grant services with clients who may need them. This was done in the context of our federator project in Ensias. You can check the report [here](https://github.com/Ignema/Bricoly/blob/master/res/Report.pdf).

## 🔍 Instructions

The first thing we need to do is clone the repository and get the code:

    git clone https://github.com/Ignema/Bricoly.git

### 📌 Running the code locally from source

There are four things that we need to execute the whole application.

- **Postgres Database** (Make sure you edit *application.properties* with the right credentials so that the backend can detect your database)
- **JDK 17** ⚠️ (An IDE like intellij or eclipse will do the work automatically for you)
   
        # Windows
        gradlew bootRun
        # Linux
        ./gradlew bootRun
- **Node**

        npm install

- **Angular-CLI**
        
        npm install -g @angular/cli 
        ng serve --open

### 📌 Running the project with containers

If you want to run the containers seperately then you can pull them independently from docker hub like so
    
    # Frontend
    docker pull ignema/bricoly-frontend

    # Backend
    docker pull ignema/bricoly-backend

    # Don't forget to run a postgres container as well!!!

If you want to run the cluster at once, you can simply run this command **(Recommended)**

    docker-compose -p bricoly up

### 📌 Running the project with kubernetes

If kubernetes is more up your alley you can use the k8s config to deploy the cluster

    kubectl apply -f k8s/deployments

    kubectl apply -f k8s/services

    watch -n 0.5 kubectl get all
## 📅 Database Schema

<p align="center">
<img src="https://raw.githubusercontent.com/Ignema/Bricoly/master/res/SQL/schema.png?token=GHSAT0AAAAAABQA32QBVENAZ6O25U3TLXR6YQQNSZA" />
</p>

## 🎨 Mockup Design

The initial designs were made with Figma. You can check them [here](https://www.figma.com/file/ffdOobahZ6Eba8LD0QAEyU/Bricoly?node-id=0%3A1).

<p align="center">
<img src="https://raw.githubusercontent.com/Ignema/Bricoly/master/res/Screenshots/0.png" />
</p>

## ⚙️ App Overview

### 📃 Landing Page

<p align="center">
<img src="https://raw.githubusercontent.com/Ignema/Bricoly/master/res/Screenshots/1.png" />
</p>

By the way, here's the original pictures used in the landing page's carousel:

<p align="center">
<img src="https://raw.githubusercontent.com/Ignema/Bricoly/master/frontend/src/assets/1.png?token=GHSAT0AAAAAABQA32QALIWCTYTYB7UHLUWEYQQXHFQ" width="250" height="auto" />
<img src="https://raw.githubusercontent.com/Ignema/Bricoly/master/frontend/src/assets/2.png?token=GHSAT0AAAAAABQA32QAP3MSXTYPSKIEKYFCYQQXIGQ" width="250" height="auto" />
<img src="https://raw.githubusercontent.com/Ignema/Bricoly/master/frontend/src/assets/3.png?token=GHSAT0AAAAAABQA32QADVUC4VIXOSY7OBAYYQQXIRQ" width="250" height="auto" />
</p>

### 📃 About Page

<p align="center">
<img src="https://raw.githubusercontent.com/Ignema/Bricoly/master/res/Screenshots/2.png" />
</p>

<p align="center">
<img src="https://raw.githubusercontent.com/Ignema/Bricoly/master/res/Screenshots/3.png" />
</p>

### 📃 Login Page

<p align="center">
<img src="https://raw.githubusercontent.com/Ignema/Bricoly/master/res/Screenshots/4.png" />
</p>

### 📃 Register Page

<p align="center">
<img src="https://raw.githubusercontent.com/Ignema/Bricoly/master/res/Screenshots/5.png" />
</p>

### 📃 Catalog Page

<p align="center">
<img src="https://raw.githubusercontent.com/Ignema/Bricoly/master/res/Screenshots/6.png" />
</p>

### 📃 Offer Detail Page

<p align="center">
<img src="https://raw.githubusercontent.com/Ignema/Bricoly/master/res/Screenshots/7.png" />
</p>

### 📃 Provider Profile Page

<p align="center">
<img src="https://raw.githubusercontent.com/Ignema/Bricoly/master/res/Screenshots/8.png" />
</p>

### 📃 Dashboard Section
#### 🗞️ Dashboard Profile Edit Page

<p align="center">
<img src="https://raw.githubusercontent.com/Ignema/Bricoly/master/res/Screenshots/9.png" />
</p>

<p align="center">
<img src="https://raw.githubusercontent.com/Ignema/Bricoly/master/res/Screenshots/10.png" />
</p>

#### 🗞️ Dashboard Offer History

<p align="center">
<img src="https://raw.githubusercontent.com/Ignema/Bricoly/master/res/Screenshots/11.png" />
</p>

#### 🗞️ Dashboard Add Offer Modal

<p align="center">
<img src="https://raw.githubusercontent.com/Ignema/Bricoly/master/res/Screenshots/12.png" />
</p>

#### 🗞️ Dashboard Job Feed

<p align="center">
<img src="https://raw.githubusercontent.com/Ignema/Bricoly/master/res/Screenshots/13.png" />
</p>

### 📃 Swagger UI of Backend API

<p align="center">
<img src="https://raw.githubusercontent.com/Ignema/Bricoly/master/res/Screenshots/14.png" />
</p>


<pre>
<p style="font-size:2rem;" align="center">
Made with 💙 by Ignema
</p>
</pre>