# AI-Driven Cucumber Test

[![CI](https://github.com/aritrasur47/claude-cucumber-automation/actions/workflows/ci.yml/badge.svg)](https://github.com/aritrasur47/claude-cucumber-automation/actions/workflows/ci.yml)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)
[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://openjdk.org/projects/jdk/21/)
[![Cucumber](https://img.shields.io/badge/Cucumber-7.23.0-23D96C.svg)](https://cucumber.io/)
[![Selenium](https://img.shields.io/badge/Selenium-4.34.0-43B02A.svg)](https://www.selenium.dev/)

BDD test automation framework using Cucumber, Selenium WebDriver, and TestNG.

> 🤖 **Built with [Claude Code](https://claude.com/claude-code)** — this project's cross-browser WebDriver support, documentation, and repo setup were developed using Claude Code.

> 📚 This is a personal learning project built while following [Rahul Shetty Academy](https://rahulshettyacademy.com/) Selenium/Cucumber courses on Udemy. The practice application under test (`rahulshettyacademy.com/seleniumPractise`) is a public site provided by the same academy for learners.

## Prerequisites

- Java 21
- Maven
- One of: Google Chrome, Mozilla Firefox, Safari (macOS), or Microsoft Edge

## Setup

```bash
git clone https://github.com/aritrasur47/claude-cucumber-automation.git
cd claude-cucumber-automation
mvn compile
```

## Running Tests

```bash
mvn test -Dtest=TestNGTestRunner
```

Reports are generated under `target/` (ExtentReports HTML, TestNG, and Allure results).

## Browser Configuration

The browser is selected via `src/test/resources/global.properties`:

```properties
browser=chrome
QAUrl=https://rahulshettyacademy.com/seleniumPractise/#/
```

Supported values for `browser` (case-insensitive): `chrome`, `firefox`, `safari`, `edge`.

Driver setup is handled by Selenium Manager automatically for Chrome, Firefox, and Edge — no manual driver downloads needed.

### Safari

Safari requires one-time setup before it can be controlled via WebDriver:

1. Open Safari → **Safari menu → Settings → Advanced** → enable **"Show features for web developers"**.
2. Open the **Develop** menu (now visible in the menu bar) → enable **"Allow Remote Automation"**.
3. Run once in a terminal: `sudo safaridriver --enable`

### Edge

Requires Microsoft Edge to be installed on the machine running the tests.
