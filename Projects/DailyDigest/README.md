# Daily Email Digest

Generates and sends a customised email digest.

Followed "https://www.linkedin.com/learning/python-projects" to refresh my Python knowledge.

## User Stories

User stories describe a single scenario from the user's perspective. They should short and simplt.

Let's keep the initial scope reasonable. We can add more features later.

- As a recipient, I want to receive an email every morning with current and useful information 
so that I know what is going in the world.
- As a recipient, I want to read an inspirational quote so that I have something to ponder thought my day.
- As a recipient, I want to know the weather forecast so that I know how to dress.

- As an admin, I want to choose what content to include so that I can create the best experience for my recipients.
- As an admin, I want to add and remove recipients so that I can control who receives the daily digest email.

## Use Cases

Title: Read Twitter trends 
Actor: Recipient
Scenario: 
    1. Opens the digest email
    2. Sees an interesting Twitter trend
    3. Clicks on the trend link
    4. Opens a web browser to a page or related tweets

## Functional Requirements

- Generate a random inspirational quote
- Retrieve current weather forecast for location
- Retrieve current Twitter trends
- Retrieve a random Wikipedia article
- Format content into an email
- Send email to specified recipients


## Non-functional Requirements

Such requirements answer to "How should it do something?".

For example, "The application should be configurable by the admin using a GUI" focuses on the nonfunctional requirements 
for usability.

- The application should be configurable by the admin using a GUI
- Extensible to add more content types
- Resilient to content errors

