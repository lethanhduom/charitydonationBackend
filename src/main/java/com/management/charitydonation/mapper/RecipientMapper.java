package com.management.charitydonation.mapper;

import com.management.charitydonation.dto.RecipientDto;
import com.management.charitydonation.entity.Recipient;

public class RecipientMapper {
public static RecipientDto mapRecipientDto(Recipient recipient) {
	if(recipient==null)
		return null;
	RecipientDto recipientdto=new RecipientDto();
	recipientdto.setIdRecipient(recipient.getIdRecipient());
	recipientdto.setAcadamyStartYear(recipient.getAcadamyStartYear());
	recipientdto.setAcadamyEndYear(recipient.getAcadamyEndYear());
	recipientdto.setFaculty(recipient.getFaculty());
	recipientdto.setFullName(recipient.getFullName());
	recipientdto.setNumberStudent(recipient.getNumberStudent());
	recipientdto.setSpecialized(recipient.getSpecialized());
	recipientdto.setClassRecipient(recipient.getClassRecipient());
	return recipientdto;
}
public static Recipient mapRecipient(RecipientDto recipientdto) {
	if(recipientdto==null)
		return null;
	Recipient recipient=new Recipient();
	recipient.setIdRecipient(recipientdto.getIdRecipient());
	recipient.setAcadamyStartYear(recipientdto.getAcadamyStartYear());
	recipient.setAcadamyEndYear(recipientdto.getAcadamyEndYear());
	recipient.setFaculty(recipientdto.getFaculty());
	recipient.setFullName(recipientdto.getFullName());
	recipient.setNumberStudent(recipientdto.getNumberStudent());
	recipient.setSpecialized(recipientdto.getSpecialized());
	recipient.setClassRecipient(recipientdto.getClassRecipient());
	return recipient;
}
}
