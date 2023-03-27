package com.xronos.constants;

import io.github.xronoshft.constants.ContractTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
class ContractTypeEnumTest {

  @Test
  public void testContractTypeEnum() {
    log.info(ContractTypeEnum.CW.name());
    log.info(ContractTypeEnum.valueOf("CW").name());
  }
}