package io.swagger.model;

import java.math.BigDecimal;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;




/**
 * Challenger
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-12T09:35:55.338Z")

public class Challenger   {
  private BigDecimal id = null;

  private String name = null;

  public Challenger id(BigDecimal id) {
    this.id = id;
    return this;
  }

   /**
   * The id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "The id")
  public BigDecimal getId() {
    return id;
  }

  public void setId(BigDecimal id) {
    this.id = id;
  }

  public Challenger name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "The name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Challenger challenger = (Challenger) o;
    return Objects.equals(this.id, challenger.id) &&
        Objects.equals(this.name, challenger.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Challenger {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

