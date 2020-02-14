<%@ include file="header.jsp" %>

<div class="container-fluid">
    <div class="row">
        <div class="col-12 bg-warning text-light d-flex justify-content-center align-items-center" style="height: 100vh">
            <form action="signIn" method="post">
                <div class="form-group">
                    <label><fmt:message key="reg.email" /></label>
                    <input type="text" name="email" class="form-control" >
                </div>
                <div class="form-group">
                    <label><fmt:message key="reg.password" /></label>
                    <input type="password" name="password" class="form-control">
                </div>

                <button type="submit" class="btn btn-primary"><fmt:message key="reg.signIn" /></button>
            </form>
        </div>
    </div>
</div>
