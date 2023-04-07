<h1>My Books</h1>
<p>Welcome, ${pageContext.request.userPrincipal.name}!</p>
<table>
    <tr>
        <th>Title</th>
        <th>Author</th>
        <th>Year</th>
    </tr>
    <c:forEach var="book" items="${myBooks}">
        <tr>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.year}</td>
        </tr>
    </c:forEach>
</table>
