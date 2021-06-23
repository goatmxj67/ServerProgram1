package test;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dao.StaffDAO;

class StaffTEST {
	
	@BeforeEach
	void setUp() throws Exception {
		
		
	}

	@Test
	@DisplayName("test()")
	void test() {
		
		assertNull(StaffDAO.getInstance().selectPersonBySno("99999"), "사원 등록 또는 사원 검색에 문제가 있습니다.");
		
	}

}
