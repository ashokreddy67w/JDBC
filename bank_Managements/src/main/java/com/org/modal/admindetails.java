package com.org.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class admindetails {
//	Admin_Emalid_id, Password, Admin_Role
  private int id;
  private String Admin_Emalid_id;
  private String Password;
  private String Admin_Role;
}
