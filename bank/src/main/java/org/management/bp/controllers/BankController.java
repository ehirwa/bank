package org.management.bp.controllers;

import java.util.List;
import javax.validation.Valid;
import org.management.bp.domain.IBankDomain;
import org.management.bp.entities.Account;
import org.management.bp.entities.Operation;
import org.management.bp.models.BankForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BankController {
	@Autowired
	private IBankDomain domain;

	@RequestMapping(value = "/index")

	public String index(Model model) {
		model.addAttribute("bankForm", new BankForm());
		return "bank";
	}

//	accountCharge
	@RequestMapping(value = "/accountCharge")

	public String charge(@Valid BankForm bf, BindingResult bindingResult, Model model) {// asking spring to validate
		if (bindingResult.hasErrors()) {
			return "bank";
		}

		accountCharge(bf);
		model.addAttribute("bankForm", bf);
		return "bank";
	}

	@RequestMapping(value = "/saveOperation")
	public String saveOp(@Valid BankForm bf, BindingResult bindingResult) {

		try {
			if (bindingResult.hasErrors()) {
				return "bank";
			}

			if (bf.getAction() != null) {
				if (bf.getOperationType().equals("DEPO")) {
					domain.deposit(bf.getCode(), bf.getAmount(), 1L);
				} else if (bf.getOperationType().equals("WITH")) {
					domain.withdraw(bf.getCode(), bf.getAmount(), 1L);

				} else if (bf.getOperationType().equals("TRANS")) {
					domain.transfer(bf.getCode(), bf.getCode2(), bf.getAmount(), 1L);
				}
			}

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			bf.setException(e.getMessage());
		}
		accountCharge(bf);
		return "bank";

	}

	public void accountCharge(BankForm bf) {

		try {
			Account ac = domain.viewAccount(bf.getCode());
			bf.setAccountType(ac.getClass().getSimpleName());// SIMPLY RETURN CLASS NAME
			bf.setAccount(ac);
			int pos=bf.getNumberOfligns()*bf.getPage();			
			List<Operation> ops = domain.viewOperations(bf.getCode(), pos, bf.getNumberOfligns());			
			bf.setOperations(ops);
			long nbOp=domain.getNumberOfOperations(bf.getCode());
			bf.setNumberofPages((int)(nbOp/bf.getNumberOfligns())+1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			bf.setException(e.getMessage());
		}
	}
}
