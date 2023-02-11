
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<h1>What I have to do</h1>
	<table class="table">
		<thead>
			<tr>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is Done?</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${forms}" var="form">
				<tr>
					<td>${form.description}</td>
					<td>${form.targetDate}</td>
					<td>${form.done ? 'Yes' : 'No'}</td>
					<td><a href="delete-form?id=${form.id}"
						class="btn btn-danger">Delete</a></td>
					<td><a href="update-form?id=${form.id}"
						class="btn btn-success">Update</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="add-form" class="btn btn-success">Add new</a>
</div>
<%@ include file="common/footer.jspf"%>