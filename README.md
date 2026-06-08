# Automated Outreach Pipeline

## Overview

This project is a fully automated cold outreach pipeline built using Spring Boot. The system takes a single company domain as input and automatically discovers relevant contacts, enriches their information, generates personalized outreach emails, and sends them through Brevo.

The goal of the project is to demonstrate end-to-end workflow automation using real-world SaaS integrations and external APIs.

---

## Architecture

```text
Company Domain
      │
      ▼
Prospeo Search API
      │
      ▼
Contact Discovery
      │
      ▼
Prospeo Enrich API
      │
      ▼
Verified Contact Information
      │
      ▼
Email Generation
      │
      ▼
Safety Checkpoint
      │
      ▼
Brevo API
      │
      ▼
Email Delivery
```

---

## Features

### Contact Discovery

* Searches for professionals associated with a target company domain.
* Retrieves LinkedIn profiles and person identifiers.
* Uses Prospeo Search API.

### Contact Enrichment

* Uses Prospeo Enrich API.
* Retrieves:

  * First Name
  * Last Name
  * Job Title
  * LinkedIn URL
  * Verified Work Email

### Personalized Email Generation

* Generates customized outreach emails.
* Personalizes content using:

  * Contact Name
  * Current Role
  * Company Information

### Safety Checkpoint

* Displays an email preview before sending.
* Requires manual confirmation from the user.
* Prevents accidental email delivery.

### Email Delivery

* Sends emails using Brevo Transactional Email API.
* Supports verified sender domains.
* Handles API-based email delivery.

---

## Technologies Used

### Backend

* Java 21
* Spring Boot 3
* Maven

### Libraries

* Lombok
* Spring Web
* RestClient

### External Services

* Prospeo API
* Brevo API

---

## Project Structure

```text
src/main/java/com/subspace/outreachflow

├── client
│   ├── ProspeoClient
│   └── BrevoClient
│
├── dto
│   ├── SearchPersonRequest
│   ├── SearchPersonResponse
│   ├── EnrichPersonRequest
│   ├── EnrichPersonResponse
│   └── SendEmailRequest
│
├── model
│   ├── Contact
│   └── CampaignEmail
│
├── service
│   ├── ContactDiscoveryService
│   ├── EmailCampaignService
│   └── PipelineService
│
├── StartupRunner
└── OutreachflowApplication
```

---

## Workflow

### Step 1 – Input

User provides a company domain.

Example:

```text
shopify.com
```

---

### Step 2 – Contact Search

Prospeo Search API is called.

Output:

```text
Emily Green
LinkedIn Profile
Person ID
```

---

### Step 3 – Contact Enrichment

Prospeo Enrich API is called using the Person ID.

Output:

```text
Emily Green
Senior Software Developer
emily.green@shopify.com
```

---

### Step 4 – Email Generation

A personalized outreach email is generated.

Example:

```text
Subject: Quick question for Emily

Hi Emily,

I noticed you are working as Senior Software Developer.

I would love to connect and learn more about your work.

Best Regards,
Prashant
```

---

### Step 5 – Preview & Confirmation

The system displays the email preview.

```text
=== EMAIL PREVIEW ===

CampaignEmail(...)
```

User confirms:

```text
yes
```

---

### Step 6 – Email Delivery

Brevo API sends the email.

Output:

```text
Email sent successfully
```

---

## Configuration

Create:

```text
src/main/resources/application.properties
```

Example:

```properties
prospeo.api.key=YOUR_PROSPEO_API_KEY
brevo.api.key=YOUR_BREVO_API_KEY
```

---

## Running the Project

### Clone Repository

```bash
git clone <repository-url>
cd outreachflow
```

### Build Project

```bash
mvn clean install
```

### Run Application

```bash
mvn spring-boot:run
```

---

## Example Execution

```text
Input:
shopify.com

Contact Found:
Emily Green

Role:
Senior Software Developer

Email:
emily.green@shopify.com

Send email? (yes/no):
yes

Email sent successfully.
```

---

## Error Handling

The application includes handling for:

* Invalid API keys
* Missing contacts
* Missing email addresses
* Brevo delivery failures
* External API errors

The pipeline is designed to fail gracefully and provide meaningful feedback.

---

## Future Improvements

* Multiple contact processing
* Role-based filtering
* Ocean.io integration for lookalike company discovery
* Email templates
* Retry mechanism for failed deliveries
* Database persistence
* Batch campaign execution
* Email tracking and analytics

---

## Author

Prashant Surve

Spring Boot | Automation | API Integration | Outreach Systems
