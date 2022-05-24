$('#navbardiv').append(
    '<nav class="navbar navbar-expand-lg navbar-light bg-dark">\n' +
    '        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">\n' +
    '            <span class="navbar-toggler-icon"></span>\n' +
    '        </button>\n' +
    '        <div class="collapse navbar-collapse" id="navbarTogglerDemo01">\n' +
    '            <a class="navbar-brand" href="/">DS/DB Exam project</a>\n' +
    '            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">\n' +
    '                <li class="nav-item">\n' +
    '                    <a class="nav-link" href="/login">Login Page</a>\n' +
    '                </li>\n' +
    '                <li class="nav-item">\n' +
    '                    <a class="nav-link" href="#">Another link</a>\n' +
    '                </li>\n' +
    '                <li class="nav-item">\n' +
    '                    <a class="nav-link" href="#">Yet another link</a>\n' +
    '                </li>\n' +
    '            </ul>\n' +
    '            <div>\n' +
    '            <span th:if="${user.username}" style="color: lightblue">Logged In As\n' +
    '                <span style="color: dodgerblue;font-weight: bold" th:text="\' \'+${user.username}"></span>\n' +
    '                <span><a class="btn btn btn-outline-danger my-2 my-sm-0" type="submit" th:href="@{/logout}">Logout</a></span>\n' +
    '            </span>\n' +
    '                <span th:unless="${user.username}">\n' +
    '                <form class="form-inline my-2 my-lg-0" method="post" th:action="@{/login}" th:object="${user}">\n' +
    '                    <input class="form-control mr-sm-2" type="text" placeholder="Username" name="username">\n' +
    '                    <input class="form-control mr-sm-2" type="password" placeholder="Password" name="password">\n' +
    '                    <button class="btn btn btn-outline-primary my-2 my-sm-0" type="submit">Login</button>\n' +
    '                </form>\n' +
    '            </span>\n' +
    '            </div>\n' +
    '\n' +
    '        </div>\n' +
    '    </nav>'
)
