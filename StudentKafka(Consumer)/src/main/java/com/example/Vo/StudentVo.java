package com.example.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentVo {
	private int id;
	private String studentName;
	private String college;
	private String city;
	

}
