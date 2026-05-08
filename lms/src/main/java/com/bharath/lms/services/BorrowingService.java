package com.bharath.lms.services;

import com.bharath.lms.model.Borrowing;

public interface BorrowingService {
	
	Borrowing borrowBook(Long bookId,Long memberId);
	
	Borrowing returnBook(Long borrowingId);

}
