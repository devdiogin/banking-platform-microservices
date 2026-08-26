<#import "template.ftl" as layout>

<@layout.registrationLayout
    displayMessage=!messagesPerField.existsError("password", "password-confirm");
    section
>

<#if section = "header">

    <h1>
        Crie sua<br>
        <span>senha.</span>
    </h1>

    <p>
        Escolha uma senha segura para proteger sua conta Spring Bank.
    </p>

<#elseif section = "form">

    <form
        id="kc-passwd-update-form"
        class="spring-form"
        action="${url.loginAction}"
        method="post"
    >

        <div class="spring-field">

            <label for="password-new">
                Nova senha
            </label>

            <div class="spring-password-wrapper">

                <input
                    id="password-new"
                    name="password-new"
                    type="password"
                    autocomplete="new-password"
                    placeholder="Digite sua nova senha"
                    autofocus
                >

                <button
                    class="spring-password-toggle"
                    type="button"
                    data-password-toggle
                    data-password-target="password-new"
                    aria-label="Mostrar senha"
                >

                    <svg
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


        <div class="spring-field">

            <label for="password-confirm">
                Confirmar senha
            </label>

            <div class="spring-password-wrapper">

                <input
                    id="password-confirm"
                    name="password-confirm"
                    type="password"
                    autocomplete="new-password"
                    placeholder="Digite novamente sua senha"
                >

                <button
                    class="spring-password-toggle"
                    type="button"
                    data-password-toggle
                    data-password-target="password-confirm"
                    aria-label="Mostrar senha"
                >

                    <svg
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

            <#if messagesPerField.existsError("password-confirm")>

                <span class="spring-field-error">
                    ${kcSanitize(messagesPerField.get("password-confirm"))?no_esc}
                </span>

            </#if>

        </div>


        <button
            id="kc-submit"
            name="login"
            class="spring-primary-button"
            type="submit"
        >
            Criar senha
        </button>

    </form>

</#if>

</@layout.registrationLayout>