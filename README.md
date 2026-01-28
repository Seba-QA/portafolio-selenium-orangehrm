# OrangeHRM - Portafolio de Automatización con Selenium + Java + Cucumber

![CI](https://github.com/Seba-QA/parabank-automation/actions/workflows/qa-automation.yml/badge.svg)
[![Allure Report](https://img.shields.io/badge/Allure-Report-orange)](https://seba-qa.github.io/parabank-automation/)

Este proyecto forma parte de mi **portafolio profesional de automatización**, y está enfocado en la creación de **pruebas automatizadas end-to-end (E2E)** sobre la aplicación web [OrangeHRM Demo](https://opensource-demo.orangehrmlive.com/) utilizando **Selenium WebDriver**, **Java**, **JUnit** y **Cucumber (BDD)**.   

El objetivo principal es demostrar:
- **Buenas prácticas en automatización**, aplicando Page Object Model (POM).
- **Cobertura integral de funcionalidades**, desde pruebas unitarias de cada módulo hasta flujos completos E2E.
- **Documentación clara y estructurada**, para que cualquier persona pueda entender el proyecto, incluso sin conocimientos avanzados en automatización.
- **Escenarios BDD con Cucumber**, permitiendo parametrización y legibilidad en lenguaje natural.
- **Ejecución flexible** desde IDE (runner JUnit) o terminal (Maven).

Este repositorio se actualizará progresivamente, incorporando nuevos módulos, reportes automáticos y mejoras en la integración continua.

---

## **Instalación y Ejecución**

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/Seba-QA/portafolio-selenium-orangehrm.git
   cd orangehrm
   ```
2. **Instalar dependencias**
   ```bash
   mvn clean install
   ```
3. **Ejecutar todas las pruebas**
   ```bash
   mvn test
   ```
4. **Ejecutar pruebas filtradas por tag (ejemplo: @login)**
   ```bash
   mvn test -Dcucumber.filter.tags="@login"
   ```
5. **Ejecutar desde IDE (IntelliJ / VSCode)**
    - Abrir src/test/java/runner/RunCucumberTest.java
    - Ejecutar como JUnit Test


---

## **Estructura del proyecto**

```
orangehrm/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── config/          # DriverFactory y configuración general
│   │       ├── pages/           # Page Objects (BasePage + páginas específicas)
│   │       └── utils/           # Funciones reutilizables
│   │
│   └── resources/
│       └── features/            # Archivos .feature en Gherkin (BDD)
│
├── src/test/java/
│   ├── runner/                  # Runner JUnit para ejecutar los features
│   └── steps/                   # Step Definitions enlazadas a los features
│
├── pom.xml                      # Dependencias y configuración Maven
│
└── README.md                    # Este archivo
```

## **Módulos Actuales**
  - En proceso
  
---

## 📝 Reportes

    Actualmente el proyecto no incluye reportes, pero se integrarán en fases posteriores.
    Opciones a considerar:
        - Cucumber HTML Reports
        - Extent Reports
        - Allure Reports

    Los reportes serán útiles para:
        - Obtener métricas de ejecución.
        - Visualizar resultados de escenarios y pasos.
        - Integrar con CI/CD en GitHub Actions.

---

## **⚙️ Integración Continua (CI/CD)**
   **Este repositorio incluye un pipeline en GitHub Actions en versiones futuras y podrá:**
   1. Ejecuta todas las pruebas automáticamente en cada push.
   2. Generar reportes.
   3. Publicar los resultados de ejecución en GitHub Pages.

---

## **Autor**
Técnico Universitario en Informática | QA & Automatización de Pruebas  
LinkedIn: [www.linkedin.com/in/sebastián-gonzalez-qa](https://www.linkedin.com/in/sebastián-gonzalez-qa)