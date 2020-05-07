<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:output method="html"/>

    <xsl:template match="Sales">
        <xsl:apply-templates select="Person"/>
    </xsl:template>

    <xsl:template match="Person">
        <p style="color: blue; font-weight:bold; font-family: Times; margin: 8px">
            NAME: 
            <xsl:value-of select="Name"/>
            AGE: 
            <xsl:value-of select="Age"/>
            Your Commision is 
            <xsl:value-of select="Commision"/>.
        </p>
    </xsl:template>

</xsl:stylesheet>