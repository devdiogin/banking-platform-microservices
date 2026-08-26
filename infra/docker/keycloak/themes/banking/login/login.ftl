<#import "template.ftl" as layout>

<@layout.registrationLayout
    displayMessage=!messagesPerField.existsError("username", "password");
    section
>

<#if section = "header">

    <h1>
        Bem-vindo<br>
        <span>de volta.</span>
    </h1>

    <p>
        Acesse sua conta Spring Bank de forma simples e segura.
    </p>

<#elseif section = "form">

    <#if realm.password>

        <form
            id="kc-form-login"
            class="spring-form"
            action="${url.loginAction}"
            method="post"
        >

            <div class="spring-field">

                <label for="username">
                    E-mail ou usuário
                </label>

                <input
                    id="username"
                    name="username"
                    type="text"
                    value="${(login.username!'')}"
                    autocomplete="username"
                    placeholder="Digite seu e-mail ou usuário"
                    autofocus
                    aria-invalid="<#if messagesPerField.existsError('username')>true<#else>false</#if>"
                >

                <#if messagesPerField.existsError("username")>

                    <span class="spring-field-error">
                        ${kcSanitize(messagesPerField.get("username"))?no_esc}
                    </span>

                </#if>

            </div>


            <div class="spring-field">

                <div class="spring-label-row">

                    <label for="password">
                        Senha
                    </label>

                    <#if realm.resetPasswordAllowed>

                        <a
                            class="spring-forgot-password"
                            href="${url.loginResetCredentialsUrl}"
                        >
                            Esqueci minha senha
                        </a>

                    </#if>

                </div>

                <div class="spring-password-wrapper">

                    <input
                        id="password"
                        name="password"
                        type="password"
                        autocomplete="current-password"
                        placeholder="Digite sua senha"
                        aria-invalid="<#if messagesPerField.existsError('password')>true<#else>false</#if>"
                    >

                    <button
                        class="spring-password-toggle"
                        type="button"
                        data-password-toggle
                        data-password-target="password"
                        aria-label="Mostrar senha"
                    >

                        <svg
                            class="icon-eye"
                            viewBox="0 0 24 24"
                            fill="none"
                            aria-hidden="true"
                        >

                            <path
                                d="M2.5 12s3.5-6 9.5-6 9.5 6 9.5 6-3.5 6-9.5 6-9.5-6-9.5-6Z"
                                stroke="currentColor"
                                stroke-width="1.7"
                            />

                            <circle
                                cx="12"
                                cy="12"
                                r="2.7"
                                stroke="currentColor"
                                stroke-width="1.7"
                            />

                        </svg>

                    </button>

                </div>

                <#if messagesPerField.existsError("password")>

                    <span class="spring-field-error">
                        ${kcSanitize(messagesPerField.get("password"))?no_esc}
                    </span>

                </#if>

            </div>


            <input
                type="hidden"
                name="credentialId"
                <#if auth.selectedCredential?has_content>
                    value="${auth.selectedCredential}"
                </#if>
            >


            <button
                id="kc-login"
                class="spring-primary-button"
                name="login"
                type="submit"
            >
                Entrar
            </button>

        </form>

    </#if>

<#elseif section = "social">

</#if>

</@layout.registrationLayout>