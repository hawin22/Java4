<%@ include file="theme/navbar.jsp" %>
<div class="container mt-3 d-flex">
    <h3 style="flex:1">${video.title}</h3
    <div>
        <c:if test="${not empty sessionScope.username}">
            <div>
                <c:if test="${!like}">
                    <a href="/addDetail?id=${video.id}" class="btn btn-sm border-primary">Like</a>
                </c:if>
                <c:if test="${like}">
                    <a href="/deleteDetail?id=${video.id}" class="btn btn-sm border-primary">Unlike</a>
                </c:if>
            </div>
        </c:if>
    </div>
    <div class="container">
        <iframe width="100%" height="600px" src="https://www.youtube.com/embed/${video.id}" allowfullscreen></iframe>
    </div>
</div>