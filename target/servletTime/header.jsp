
<div id="app">
    <nav class="navbar navbar-expand navbar-dark bg-dark">
        <a href="#" class="navbar-brand">Time-Tracker</a>
        <div class="navbar-nav mr-auto">
            <li class="nav-item">
                <a href="index.jsp" class="nav-link">
                    <font-awesome-icon icon="home"/>
                    Home
                </a>
            </li>
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/signIn" class="nav-link">Sign In</a>
            </li>

            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/signUp" class="nav-link">Sign Up</a>
            </li>

            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/signUp" class="nav-link">Sign Up</a>
            </li>

            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/home" class="nav-link">
                    <font-awesome-icon icon="home" /> Home
                </a>
            </li>
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/admin" class="nav-link">Admin Board</a>
            </li>

            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/user" class="nav-link">User Board</a>
            </li>
        </div>

        <div class="navbar-nav ml-auto">
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/profile" class="nav-link">
                    <font-awesome-icon icon="user" />
                    Current User
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
                <font-awesome-icon icon="sign-out-alt" />
                </a>
            </li>
        </div>

        <div class="navbar-nav ml-auto">
            <li class="nav-item">

                <div class="input-group mb-3">

                    <form action="#" method="get">
                        <select name="ddlLanguage" class="custom-select" id="inputGroupSelect03">
                            <option value="en">English</option>
                            <option value="ru">Русский</option>
                        </select>

                        <div class="input-group-prepend">
                            <button class="btn btn-outline-secondary" type="submit"><fmt:message key="button"/></button>
                        </div>

                    </form>
                </div>
            </li>
        </div>
    </nav>

    <div class="container">
        <router-view/>
    </div>
</div>
