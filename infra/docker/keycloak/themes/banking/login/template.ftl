<#macro registrationLayout bodyClass="" displayInfo=false displayMessage=true displayRequiredFields=false>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">

    <meta
        name="viewport"
        content="width=device-width, initial-scale=1.0"
    >

    <meta
        name="theme-color"
        content="#071A14"
    >

    <title>Spring Bank</title>

    <#if properties.styles?has_content>
        <#list properties.styles?split(" ") as style>
            <link
                rel="stylesheet"
                href="${url.resourcesPath}/${style}"
            >
        </#list>
    </#if>

    <#if properties.scripts?has_content>
        <#list properties.scripts?split(" ") as script>
            <script
                src="${url.resourcesPath}/${script}"
                defer
            ></script>
        </#list>
    </#if>
</head>

<body class="spring-body ${bodyClass}">

<div class="spring-page">

    <header class="spring-header">

        <a class="spring-brand" href="#">
            <span class="spring-logo">
                S
            </span>

            <span class="spring-brand-name">
                Spring Bank
            </span>
        </a>

    </header>

    <main class="spring-layout">

        <section class="spring-auth">

            <div class="spring-auth-content">

                <div class="spring-page-title">
                    <#nested "header">
                </div>

                <#if displayMessage && message?has_content>

                    <div
                        class="spring-alert spring-alert-${message.type}"
                        role="alert"
                    >
                        ${kcSanitize(message.summary)?no_esc}
                    </div>

                </#if>

                <div class="spring-form-container">
                    <#nested "form">
                </div>

                <#if displayInfo>

                    <div class="spring-info">
                        <#nested "info">
                    </div>

                </#if>

                <div class="spring-social">
                    <#nested "social">
                </div>

            </div>

        </section>

        <aside
            class="spring-visual"
            aria-hidden="true"
        >

            <div class="spring-visual-content">

                <div class="spring-orbit spring-orbit-large"></div>
                <div class="spring-orbit spring-orbit-medium"></div>
                <div class="spring-orbit spring-orbit-small"></div>

                <div class="spring-visual-brand">
                    <span>S</span>
                </div>

            </div>

            <div class="spring-visual-message">
                <span>Spring Bank</span>

                <p>
                    Simples por natureza.<br>
                    Seguro por princípio.
                </p>
            </div>

        </aside>

    </main>

    <footer class="spring-footer">

        <div class="spring-security">

            <svg
                width="14"
                height="14"
                viewBox="0 0 24 24"
                fill="none"
                aria-hidden="true"
            >
                <path
                    d="M7 10V7a5 5 0 0 1 10 0v3"
                    stroke="currentColor"
                    stroke-width="1.7"
                    stroke-linecap="round"
                />

                <rect
                    x="5"
                    y="10"
                    width="14"
                    height="10"
                    rx="2"
                    stroke="currentColor"
                    stroke-width="1.7"
                />
            </svg>

            Ambiente seguro Spring Bank

        </div>

    </footer>

</div>

</body>
</html>

</#macro>