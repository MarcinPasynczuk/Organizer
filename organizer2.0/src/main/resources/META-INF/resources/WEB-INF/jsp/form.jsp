
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<h1>Enter Todo Details</h1>
	<form:form method="post" modelAttribute="form">

		<fieldset class="mb-3">
			<form:label path="description">Description</form:label>
			<form:input type="text" path="description" required="required" />
			<form:errors path="description" cssClass="text-warning" />
		</fieldset>

		<fieldset class="mb-3">
			<form:label path="targetDate">Target Date</form:label>
			<form:input type="text" path="targetDate" required="required" />
			<form:errors path="targetDate" cssClass="text-warning" />
		</fieldset>

<fieldset class="mb-3">
	<form:label path="done">It is done?</form:label>
	<form:checkbox path="done" class="checkbox-big" />
	<form:errors path="done" cssClass="text-warning" />
</fieldset>

<style>
.checkbox-big {
	height: 25px;
	width: 25px;
}
</style>




		<form:input type="hidden" path="id" />


		<input type="submit" class="btn btn-success" />

	</form:form>

</div>

<%@ include file="common/footer.jspf"%>
<script type="text/javascript">
	$('#targetDate').datepicker({
		format : 'yyyy-mm-dd'
	});
</script>
