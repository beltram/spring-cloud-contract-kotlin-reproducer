package contracts

import org.springframework.cloud.contract.spec.ContractDsl.Companion.contract

contract {
	request {
		method = GET
		url = url("/samples")
		headers {
			contentType = APPLICATION_JSON
		}
	}
	response {
		status = OK
		headers {
			contentType = APPLICATION_JSON
		}
	}
}
