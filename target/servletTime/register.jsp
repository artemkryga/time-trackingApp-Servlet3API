<%@ include file="header.jsp" %>
<!DOCTYPE html>

<div class="container-fluid">
    <div class="row">
        <div class="col-12 bg-dark text-light d-flex justify-content-center align-items-center" style="height: 100vh">
            <form action="signUp" method="post">
                <div class="form-group">
                    <label><fmt:message key="reg.username" /></label>
                    <input type="text" name="username" class="form-control" >
                </div>
                <div class="form-group">
                    <label><fmt:message key="reg.email" /></label>
                    <input type="email" name="email" class="form-control" aria-describedby="emailHelp">
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                </div>
                <div class="form-group">
                    <label><fmt:message key="reg.password" /></label>
                    <input type="password" name="password" class="form-control">
                </div>

                <button type="submit" class="btn btn-primary"><fmt:message key="reg.signUp" /></button>
            </form>
        </div>
    </div>
</div>
