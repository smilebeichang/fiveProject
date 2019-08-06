package net.wanho.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tree {
	private int pid;
	private String pname;
	private int parentId;
	private boolean checked=false;

	
}
