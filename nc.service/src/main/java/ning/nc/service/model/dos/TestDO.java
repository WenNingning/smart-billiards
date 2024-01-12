package ning.nc.service.model.dos;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ning.nc.framework.database.annotation.Column;
import ning.nc.framework.database.annotation.Id;
import ning.nc.framework.database.annotation.PrimaryKeyField;
import ning.nc.framework.database.annotation.Table;

import java.io.Serializable;

/**
 * @author 14279
 */
@Table(name = "test")
@ApiModel
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TestDO implements Serializable {

  @Column(name = "id")
  @ApiModelProperty(hidden = true)
  @Id(name = "id")
  private Long id;

  @Column(name = "name")
  @ApiModelProperty(value = "名称", required = false)
  private String name;


  @PrimaryKeyField
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
