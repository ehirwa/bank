<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bank</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style1.css" />
</head>

<body>
	<div>
		<f:form modelAttribute="bankForm" method="post" action="accountCharge">

			<table>
				<tr>
					<td>Code :</td>
					<td><f:input path="code" /></td>
					<td><f:errors path="code"></f:errors></td>
				</tr>
				<tr>
					<td><input type="submit" value="OK"></td>
				</tr>
			</table>
		</f:form>
	</div>
	<c:if test="${not empty bankForm.account}">
		<div>
			<table>
				<tr>
					<td>Amount :</td>
					<td>${bankForm.account.amount}</td>
				</tr>
				<tr>
					<td>creation Date :</td>
					<td>${bankForm.account.creationDate}</td>
				</tr>
				<tr>
					<td>Account Type :</td>
					<td>${bankForm.accountType}</td>
				</tr>
				<c:if test="${empty bankForm.exception}">
					<c:if test="${bankForm.accountType=='CurrentAccount' }">
						<td>Overdraft :</td>
						<td>${bankForm.account.overdraft}</td>
					</c:if>
					<c:if test="${bankForm.accountType=='SavingAccount' }">

						<td>Rate :</td>
						<td>${bankForm.account.rate}</td>
					</c:if>
				</c:if>

			</table>
		</div>
		<div>
			<table>
				<tr>
					<td>Customer Name:</td>
					<td>${bankForm.account.customer.customerName}</td>

				</tr>


			</table>
		</div>
		<div>
			<table>
				<tr>

					<td>Employee Name :</td>
					<td>${bankForm.account.employee.employeeName}</td>
				</tr>

			</table>
		</div>


		<div>
			<f:form modelAttribute="bankForm" action="saveOperation">

				<f:hidden path="code" />
				<table>
					<tr>
						<td>Deposit <f:radiobutton path="operationType" value="DEPO"
								onclick="this.form.submit()" /></td>
						<td>Withdraw <f:radiobutton path="operationType" value="WITH"
								onclick="this.form.submit()" /></td>
						<td>Transfer <f:radiobutton path="operationType"
								value="TRANS" onclick="this.form.submit()" /></td>
					</tr>
					<c:if test="${not empty bankForm.operationType}">
						<tr>
							<td>Amount :</td>
							<td><f:input path="amount" /></td>
							<td><f:errors path="amount" /></td>
						</tr>


						<c:if test="${bankForm.operationType=='TRANS'}">
							<tr>
								<td>To the account :</td>
								<td><f:input path="code2" /></td>
								<td><f:errors path="code2"></f:errors></td>
							</tr>
						</c:if>


						<tr>
							<td><input type="submit" name="action" value="Save"></td>
						</tr>
					</c:if>
				</table>


			</f:form>

		</div>


		<div>
			<table class="table1">

				<tr>
					<th>OpNum</th>
					<th>Type</th>
					<th>Date</th>
					<th>Amount</th>
				</tr>
				<c:forEach items="${bankForm.operations}" var="op">
					<tr>
						<td>${op.opnumber}</td>
						<td>${op}</td>
						<td>${op.operationDate}</td>
						<td>${op.amount}</td>
					</tr>
				</c:forEach>
			</table>
<%--
Pagination
<div>
				<c:forEach begin="0" end="${bankForm.numberofPages-1}" var="p">
					<c:choose>
						<c:when test="${p==bankForm.page}">
							<span>Page ${p}</span>
						</c:when>
					</c:choose>
					<c:otherwise>
						<span><a href="accountCharge?page=${p}&code=${bankForm.code}">Page ${p}</a></span>
					</c:otherwise>
				</c:forEach>
			</div>




 --%>
			
		</div>



	</c:if>
	<c:if test="${not empty bankForm.exception }">
		<div>${bankForm.exception}</div>
	</c:if>

</body>
</html>