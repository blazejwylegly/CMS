package com.wylegly.clinic.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "examination")
public class Examination extends Procedure{

}
