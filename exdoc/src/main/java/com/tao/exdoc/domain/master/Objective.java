package com.tao.exdoc.domain.master;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tao.exdoc.domain.SimpleMasterObject;
@JsonInclude(Include.NON_NULL)
public abstract class Objective extends SimpleMasterObject{
		
		public Objective()
		{
			
		}
		
}
